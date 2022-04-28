package com.monk.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.monk.order.entity.OrderPo;
import com.monk.order.mapper.OrderMapper;
import com.monk.order.service.IOrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, OrderPo> implements IOrderService {
}
