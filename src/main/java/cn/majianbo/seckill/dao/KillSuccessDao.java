package cn.majianbo.seckill.dao;

import cn.majianbo.seckill.entity.KillSuccess;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author majb
 * @date 2018/9/6
 */
@Component("killSuccessDao")
public interface KillSuccessDao {
    @Insert("insert into kill_success(goods_id, phone, create_time) values(#{goodsId}, #{phone}, #{createTime})")
    @Options(useGeneratedKeys = true, keyColumn = "kill_id", keyProperty = "killId")
    int add(KillSuccess info);

    @Select("select * from kill_success where goods_id = #{goodsId} order by create_time desc, phone")
    List<KillSuccess> findByGoodsId(int goodsId);

    @Select("select * from kill_success where phone = #{phone} order by create_time desc, goods_id")
    List<KillSuccess> findByPhone(String phone);
}
