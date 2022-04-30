package com.monk.order.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.monk.order.entity.OrderPo;
import com.monk.order.mapper.OrderMapper;
import com.monk.order.service.IOrderService;
import com.monk.order.service.feign.AccountFeignService;
import com.monk.order.service.feign.StorageFeignService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderServiceImpl extends ServiceImpl<OrderMapper, OrderPo> implements IOrderService {

    @Autowired
    private AccountFeignService accountFeignService;

    @Autowired
    private StorageFeignService storageFeignService;

    @Override
    @GlobalTransactional
    public boolean create(OrderPo po) {

        log.info("----->开始新建订单");
        po.setStatus(0);
        po.initCreate();
        super.save(po);

        log.info("----->订单微服务开始调用库存，做扣减Count");
        storageFeignService.decrease(po.getProductId(), po.getCount());
        log.info("----->订单微服务开始调用库存，做扣减end");


        log.info("----->订单微服务开始调用账户，做扣减Money");
        accountFeignService.decrease(po.getUserId(), po.getMoney());
        log.info("----->订单微服务开始调用账户，做扣减end");

        log.info("----->修改订单状态开始");
        updateStatuById(po.getId(), 1);
        log.info("----->修改订单状态结束");

        return true;
    }

    boolean updateStatuById(Long orderId, Integer statu) {
        OrderPo po = new OrderPo();
        po.setStatus(statu);
        po.initUpdate();
        return super.update(po, new QueryWrapper<OrderPo>().lambda()
                .eq(OrderPo::getId, orderId)
                .eq(OrderPo::getValidFlag, true));
    }
}
