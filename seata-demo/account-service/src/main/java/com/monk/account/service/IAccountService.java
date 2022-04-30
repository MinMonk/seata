package com.monk.account.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.monk.account.entity.AccountPo;

import java.math.BigDecimal;

public interface IAccountService extends IService<AccountPo> {

    AccountPo queryByUserId(Long userId);

    boolean decrease(Long userId, BigDecimal money);
}
