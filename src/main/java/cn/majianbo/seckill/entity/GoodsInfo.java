package cn.majianbo.seckill.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author majb
 * @date 2018/9/6
 */
@Data
public class GoodsInfo {
    private int goodsId;
    private String goodsName;
    private int number;
    private Date startTime;
    private Date endTime;
    private Date createTime;
}
