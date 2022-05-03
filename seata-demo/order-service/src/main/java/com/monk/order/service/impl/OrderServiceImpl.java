package com.monk.order.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.monk.order.entity.OrderPo;
import com.monk.order.mapper.OrderMapper;
import com.monk.order.service.IOrderService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderServiceImpl extends ServiceImpl<OrderMapper, OrderPo> implements IOrderService {

    @Override
    // @GlobalTransactional
    public boolean create(OrderPo po) {
        po.setStatus(0);
        po.initCreate();
        return super.save(po);
    }

    @Override
    // @GlobalTransactional
    public boolean updateStatuById(Long orderId, Integer statu) {
        OrderPo po = new OrderPo();
        po.setStatus(statu);
        po.initUpdate();
        return super.update(po, new QueryWrapper<OrderPo>().lambda()
                .eq(OrderPo::getId, orderId)
                .eq(OrderPo::getValidFlag, true));
    }
}
