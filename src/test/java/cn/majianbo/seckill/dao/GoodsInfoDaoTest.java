package cn.majianbo.seckill.dao;

import cn.majianbo.seckill.entity.GoodsInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @author majb
 * @date 2018/9/6
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GoodsInfoDaoTest {
    @Autowired
    private GoodsInfoDao goodsInfoDao;

    @Test
    public void reduceNumber() {
        goodsInfoDao.reduceNumber(3);
    }

    @Test
    public void findById() {
        GoodsInfo goodsInfo = goodsInfoDao.findById(1);
        System.out.println(goodsInfo.toString());
    }

    @Test
    public void add() {
        GoodsInfo info = new GoodsInfo();
        info.setGoodsName("123");
        info.setNumber(100);
        info.setStartTime(new Date());
        info.setEndTime(new Date());
        info.setCreateTime(new Date());
        if (goodsInfoDao.add(info) == 1) {
            System.out.println(info);
        }
    }

    @Test
    public void findAll() {
    }
}