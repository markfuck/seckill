package cn.majianbo.seckill.exception;

import lombok.Data;

/**
 * @author majb
 * @date 2018/9/6
 */
@Data
public class SeckillException extends RuntimeException {
    private int code;
    private String msg;

    public static SeckillException create(SeckillEnum seckillEnum) {
        SeckillException exception = new SeckillException();
        exception.setCode(seckillEnum.getCode());
        exception.setMsg(seckillEnum.getMsg());
        return exception;
    }
}
