package com.monk.account.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.monk.account.entity.AccountPo;
import com.monk.account.mapper.AccountMapper;
import com.monk.account.service.IAccountService;
import com.monk.common.constant.ErrorCodeEnum;
import com.monk.common.exception.BusinessException;
import io.seata.common.util.CollectionUtils;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, AccountPo> implements IAccountService {

    @Override
    public AccountPo queryByUserId(Long userId) {
        final List<AccountPo> list = super.list(new QueryWrapper<AccountPo>().lambda()
                .eq(AccountPo::getUserId, userId)
                .eq(AccountPo::getValidFlag, true));
        if (CollectionUtils.isNotEmpty(list)) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public boolean save(AccountPo data) {
        data.initCreate();
        return super.save(data);
    }

    @Override
    public boolean decrease(Long userId, BigDecimal money) {
        AccountPo dbData = queryByUserId(userId);
        if (null == dbData) {
            throw new BusinessException(ErrorCodeEnum.DATA_NOT_FOUNT);
        }

        if (dbData.getResidue().subtract(money).doubleValue() < 0) {
            throw new BusinessException(ErrorCodeEnum.INSUFFICIENT_FUND);
        }

        AccountPo po = new AccountPo();
        po.setResidue(dbData.getResidue().subtract(money));
        po.setUsed(dbData.getUsed().add(money));
        return super.update(po, new QueryWrapper<AccountPo>().lambda()
                .eq(AccountPo::getUserId, userId)
                .eq(AccountPo::getValidFlag, true));
    }
}
