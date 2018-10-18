package cn.majianbo.seckill.exception;

/**
 * @author majb
 * @date 2018/9/6
 */
public enum SeckillEnum {

    SECKILL_ERROR(1000001, "秒杀失败"),
    SECKILL_NOT_START_TIME(1000002, "秒杀未开始"),
    SECKILL_NOT_END_TIME(1000002, "秒杀已经结束"),
    SECKILL_REPEAT(1000004, "重复秒杀");

    private int code;
    private String msg;

    SeckillEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
