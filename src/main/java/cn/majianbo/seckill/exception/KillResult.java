package cn.majianbo.seckill.exception;

import lombok.Data;

/**
 * @author majb
 * @date 2018/9/7
 */
@Data
public class KillResult<T> {
    private int code;
    private String msg;
    private T result;

    public KillResult(T result) {
        this.code = 200;
        this.msg = "成功";
        this.result = result;
    }

    public KillResult() {
    }

    public KillResult(SeckillEnum seckillEnum, T result) {
        this.code = seckillEnum.getCode();
        this.msg = seckillEnum.getMsg();
        this.result = result;
    }
}
