package com.monk.order.controller;

import com.monk.common.entity.JsonVo;
import com.monk.order.entity.OrderPo;
import com.monk.order.service.IOrderService;
import com.monk.order.service.impl.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author monk
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private BusinessService orderService;

    @PostMapping("/create")
    public JsonVo create(@RequestBody OrderPo order){
        return new JsonVo().data(orderService.create(order));
    }
}
