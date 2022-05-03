package com.monk.order.service.impl;

import com.monk.common.entity.JsonVo;
import com.monk.common.exception.BusinessException;
import com.monk.order.OrderServer;
import com.monk.order.entity.OrderPo;
import com.monk.order.service.IOrderService;
import com.monk.order.service.feign.AccountFeignService;
import com.monk.order.service.feign.StorageFeignService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BusinessService {

    @Autowired
    private AccountFeignService accountFeignService;

    @Autowired
    private StorageFeignService storageFeignService;

    @Autowired
    private IOrderService orderService;

    @GlobalTransactional(rollbackFor = Exception.class)
    public JsonVo create(OrderPo po){

        log.info("----->创建订单start");
        orderService.create(po);
        log.info("----->创建订单end");

        log.info("----->订单微服务开始调用库存，做扣减Count");
        JsonVo storageResponse = storageFeignService.decrease(po.getProductId(), po.getCount());
        if(!JsonVo.SUCCESS_CODE.equals(storageResponse.getCode())){
            throw new BusinessException(storageResponse.getCode(), storageResponse.getMessage());
        }
        log.info("----->订单微服务开始调用库存，做扣减end");


        log.info("----->订单微服务开始调用账户，做扣减Money");
        JsonVo accountResponse = accountFeignService.decrease(po.getUserId(), po.getMoney());
        if(!JsonVo.SUCCESS_CODE.equals(accountResponse.getCode())){
            throw new BusinessException(accountResponse.getCode(), accountResponse.getMessage());
        }
        log.info("----->订单微服务开始调用账户，做扣减end");

        log.info("更新订单状态start");
        orderService.updateStatuById(po.getId(), 1);
        log.info("更新订单状态end");

        return new JsonVo();
    }
}
