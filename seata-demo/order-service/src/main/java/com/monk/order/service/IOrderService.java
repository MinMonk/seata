package com.monk.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.monk.order.entity.OrderPo;

/**
 * @author monk
 */
public interface IOrderService extends IService<OrderPo> {

    boolean create(OrderPo po);
}
