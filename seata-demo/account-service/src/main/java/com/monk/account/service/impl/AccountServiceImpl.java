package com.monk.account.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.monk.account.entity.AccountPo;
import com.monk.account.mapper.AccountMapper;
import com.monk.account.service.IAccountService;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, AccountPo> implements IAccountService {
}
