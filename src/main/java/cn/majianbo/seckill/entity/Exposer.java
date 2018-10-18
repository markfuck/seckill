package cn.majianbo.seckill.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author majb
 * @date 2018/9/6
 */
@Data
public class Exposer {
    private int isKillTime;
    private String md5;
    private int goodsId;
    private Date nowTime;
    private Date startTime;
    private Date endTime;

    public Exposer(int isKillTime, String md5, int goodsId, Date nowTime, Date startTime, Date endTime) {
        this.isKillTime = isKillTime;
        this.md5 = md5;
        this.goodsId = goodsId;
        this.nowTime = nowTime;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
