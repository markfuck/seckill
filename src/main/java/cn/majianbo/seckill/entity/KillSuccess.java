package cn.majianbo.seckill.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author majb
 * @date 2018/9/6
 */
@Data
public class KillSuccess {
    private int killId;
    private int goodsId;
    private String phone;
    private Date createTime;
}
