package com.monk.storage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.monk.common.constant.ErrorCodeEnum;
import com.monk.common.entity.LoginUser;
import com.monk.common.exception.BusinessException;
import com.monk.storage.entity.StoragePo;
import com.monk.storage.mapper.StorageMapper;
import com.monk.storage.service.IStorageService;
import io.seata.common.util.CollectionUtils;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author monk
 */
@Service
public class StorageServiceImpl extends ServiceImpl<StorageMapper, StoragePo> implements IStorageService {

    @Override
    // @GlobalTransactional
    public boolean decrease(String productId, Integer count) {

        final StoragePo dbData = this.queryStorageByProductId(productId);
        if (null == dbData) {
            throw new BusinessException(ErrorCodeEnum.DATA_NOT_FOUNT);
        }

        if (dbData.getResidue() - count < 0) {
            throw new BusinessException(ErrorCodeEnum.INSUFFICIENT_INVENTORY);
        }

        StoragePo po = new StoragePo();
        po.setResidue(dbData.getResidue() - count);
        po.setUsed(dbData.getUsed() + count);
        po.initUpdate();
        return super.update(po, new QueryWrapper<StoragePo>().lambda().eq(StoragePo::getProductId, productId));
    }

    @Override
    public StoragePo queryStorageByProductId(String productId) {
        List<StoragePo> storagePoList = super.list(new QueryWrapper<StoragePo>().lambda()
                .eq(StoragePo::getProductId, productId)
                .eq(StoragePo::getValidFlag, true));
        if (CollectionUtils.isEmpty(storagePoList)) {
            return null;
        }
        return storagePoList.get(0);
    }

    @Override
    public boolean save(StoragePo data) {
        data.initCreate();
        return super.save(data);
    }
}
