package cn.majianbo.seckill.dao;

import cn.majianbo.seckill.entity.KillSuccess;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author majb
 * @date 2018/9/6
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class KillSuccessDaoTest {
    @Autowired
    private KillSuccessDao dao;

    @Test
    public void add() {
        KillSuccess info = new KillSuccess();
        info.setGoodsId(2);
        info.setPhone("18566772533");
        info.setCreateTime(new Date());

        if (dao.add(info) == 1) {
            System.out.println(info);
        } else {
            System.out.println("新增失败");
        }
    }

    @Test
    public void findByGoodsId() {
        List list = dao.findByGoodsId(1);
        list.forEach(kill -> System.out.println(kill));
    }

    @Test
    public void findByPhone() {
        List list = dao.findByPhone("18566772533");
        list.forEach(kill -> System.out.println(kill));
    }
}