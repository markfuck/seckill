package cn.majianbo.seckill;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("cn.majianbo.seckill.dao")
@ComponentScan(basePackages = {"cn.majianbo.seckill.controller", "cn.majianbo.seckill.service",
        "cn.majianbo.seckill.dao", "cn.majianbo.seckill.exception"})
public class SeckillApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeckillApplication.class, args);
    }
}
