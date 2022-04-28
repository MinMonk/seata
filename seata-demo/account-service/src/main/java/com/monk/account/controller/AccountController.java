package com.monk.account.controller;

import com.monk.account.entity.AccountPo;
import com.monk.account.service.IAccountService;
import com.monk.common.entity.JsonVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author monk
 */
@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private IAccountService orderService;

    @PostMapping("/create")
    public JsonVo create(@RequestBody AccountPo order){
        return new JsonVo().data(orderService.save(order));
    }
}
