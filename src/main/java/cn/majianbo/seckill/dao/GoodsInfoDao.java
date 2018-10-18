package cn.majianbo.seckill.dao;

import cn.majianbo.seckill.entity.GoodsInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author majb
 * @date 2018/9/6
 */
@Component("goodsInfoDao")
public interface GoodsInfoDao {
    @Update("update goods_info set number = number - 1 where goods_id = #{goodsId} and number > 0")
    int reduceNumber(int goodsId);

    @Select("select * from goods_info where goods_id = #{goodsId}")
    GoodsInfo findById(int goodsId);

    @Insert("insert into goods_info(goods_name, number, start_time, end_time, create_time) values(" +
            "#{goodsName}, #{number}, #{startTime}, #{endTime}, #{createTime})")
    @Options(useGeneratedKeys = true, keyProperty = "goodsId", keyColumn = "goods_id")
    int add(GoodsInfo info);

    @Select("select * from goods_info order by create_time")
    List<GoodsInfo> findAll();
}
