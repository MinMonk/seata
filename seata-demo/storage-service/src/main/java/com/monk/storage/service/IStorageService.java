package com.monk.storage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.monk.storage.entity.StoragePo;

import java.math.BigDecimal;

public interface IStorageService extends IService<StoragePo> {

    boolean decrease(String productId, Integer count);

    StoragePo queryStorageByProductId(String productId);
}
