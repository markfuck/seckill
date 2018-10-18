package cn.majianbo.seckill.controller;

import cn.majianbo.seckill.entity.Exposer;
import cn.majianbo.seckill.entity.GoodsInfo;
import cn.majianbo.seckill.entity.KillSuccess;
import cn.majianbo.seckill.exception.KillResult;
import cn.majianbo.seckill.service.IKillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author majb
 * @date 2018/9/6
 */
@RestController
@RequestMapping(value = "/seckill/")
public class KilController {
    @Autowired
    private IKillService service;

    @RequestMapping(value = "/findAll")
    public List<GoodsInfo> findAll() {
        return service.findAll();
    }

    @RequestMapping(value = "/{goodsId}/exposeUrl")
    public KillResult<Exposer> exposeUrl(@PathVariable int goodsId) {
        return service.exposeUrl(goodsId);
    }

    @RequestMapping(value = "/{goodsId}/kill")
    public KillResult<KillSuccess> kill(@PathVariable int goodsId,
                                        @RequestParam String phone,
                                        @RequestParam String md5) {
        return service.kill(goodsId, phone, md5);
    }
}
