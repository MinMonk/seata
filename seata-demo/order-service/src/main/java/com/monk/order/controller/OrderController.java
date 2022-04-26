package com.monk.order.controller;

import com.monk.order.entity.JsonVo;
import com.monk.order.entity.OrderPo;
import com.monk.order.service.IOrderService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @PostMapping("/create")
    @GlobalTransactional
    public JsonVo create(@RequestBody OrderPo order){
        return new JsonVo().data(orderService.save(order));
    }
}
