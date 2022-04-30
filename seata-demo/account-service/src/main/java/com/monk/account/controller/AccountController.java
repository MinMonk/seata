package com.monk.account.controller;

import com.monk.account.entity.AccountPo;
import com.monk.account.service.IAccountService;
import com.monk.common.entity.JsonVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

/**
 * @author monk
 */
@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private IAccountService accountService;

    @PostMapping("/create")
    public JsonVo create(@RequestBody AccountPo order){
        return new JsonVo().data(accountService.save(order));
    }

    @GetMapping("/decrease")
    public JsonVo decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money) {
        return new JsonVo().data(accountService.decrease(userId, money));
    }
}
