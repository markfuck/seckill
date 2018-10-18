package cn.majianbo.seckill.service;

import cn.majianbo.seckill.entity.Exposer;
import cn.majianbo.seckill.entity.GoodsInfo;
import cn.majianbo.seckill.entity.KillSuccess;
import cn.majianbo.seckill.exception.KillResult;

import java.util.List;

/**
 * @author majb
 * @date 2018/9/6
 */
public interface IKillService {
    /**
     * 根据手机号查询所有秒杀记录
     *
     * @param phone
     * @return
     */
    List<KillSuccess> findAllByPhone(String phone);

    /**
     * 查询所有秒杀商品
     *
     * @return
     */
    List<GoodsInfo> findAll();

    /**
     * 执行秒杀
     *
     * @param goodsId
     * @param phone
     * @param md5
     * @return
     */
    KillResult<KillSuccess> kill(int goodsId, String phone, String md5);

    /**
     * 暴露秒杀地址
     *
     * @param goodsId
     * @return
     */
    KillResult<Exposer> exposeUrl(int goodsId);
}
