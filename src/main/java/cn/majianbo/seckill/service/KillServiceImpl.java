package cn.majianbo.seckill.service;

import cn.majianbo.seckill.dao.GoodsInfoDao;
import cn.majianbo.seckill.dao.KillSuccessDao;
import cn.majianbo.seckill.entity.Exposer;
import cn.majianbo.seckill.entity.GoodsInfo;
import cn.majianbo.seckill.entity.KillSuccess;
import cn.majianbo.seckill.exception.KillResult;
import cn.majianbo.seckill.exception.SeckillEnum;
import cn.majianbo.seckill.exception.SeckillException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;

/**
 * @author majb
 * @date 2018/9/6
 */
@Service
public class KillServiceImpl implements IKillService {
    private static final String md5Str = "dsfsak4t54y69506jdfkbvnmgkgrt2455fdfg";

    @Autowired
    private GoodsInfoDao goodsInfoDao;

    @Autowired
    private KillSuccessDao killSuccessDao;

    @Override
    public List<KillSuccess> findAllByPhone(String phone) {
        return killSuccessDao.findByPhone(phone);
    }

    @Override
    public List<GoodsInfo> findAll() {
        return goodsInfoDao.findAll();
    }

    @Override
    @Transactional(rollbackFor = SeckillException.class)
    public KillResult<KillSuccess> kill(int goodsId, String phone, String md5) {
        if (md5 == null || !md5.equals(getMd5(goodsId))) {
            return null;
        } else {
            try {
                if (goodsInfoDao.reduceNumber(goodsId) == 1) {
                    KillSuccess info = new KillSuccess();
                    info.setGoodsId(goodsId);
                    info.setPhone(phone);
                    info.setCreateTime(new Date());
                    if (killSuccessDao.add(info) == 1) {
                        return new KillResult<>(info);
                    } else {
                        throw SeckillException.create(SeckillEnum.SECKILL_REPEAT);
                    }
                } else {
                    throw SeckillException.create(SeckillEnum.SECKILL_ERROR);
                }
            } catch (Exception e) {
                if (e instanceof SeckillException) {
                    throw e;
                } else if (e instanceof DuplicateKeyException) {
                    throw SeckillException.create(SeckillEnum.SECKILL_REPEAT);
                } else {
                    throw SeckillException.create(SeckillEnum.SECKILL_ERROR);
                }
            }
        }
    }

    @Override
    public KillResult<Exposer> exposeUrl(int goodsId) {
        GoodsInfo goodsInfo = goodsInfoDao.findById(goodsId);
        if (null == goodsInfo) {
            return null;
        }
        Date startTime = goodsInfo.getStartTime();
        Date endTime = goodsInfo.getEndTime();
        Date nowTime = new Date();
        if (nowTime.getTime() < startTime.getTime()) {
            return new KillResult<>(SeckillEnum.SECKILL_NOT_START_TIME, null);
        }
        if (nowTime.getTime() > endTime.getTime()) {
            return new KillResult<>(SeckillEnum.SECKILL_NOT_END_TIME, null);
        } else {
            Exposer e = new Exposer(1, getMd5(goodsId), goodsId, nowTime, startTime, endTime);
            return new KillResult<>(e);
        }
    }

    private String getMd5(int goodsId) {
        String base = goodsId + "/" + md5Str;
        return DigestUtils.md5DigestAsHex(base.getBytes());
    }
}
