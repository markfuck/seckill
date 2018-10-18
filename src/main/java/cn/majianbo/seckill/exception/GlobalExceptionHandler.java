package cn.majianbo.seckill.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author majb
 * @date 2018/9/7
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(SeckillException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public KillResult buzExHandler(SeckillException seckillException) {
        logger.error(seckillException.toString());
        KillResult result = new KillResult();
        result.setCode(seckillException.getCode());
        result.setMsg(seckillException.getMsg());
        return result;
    }
}
