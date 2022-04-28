package com.monk.storage.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.monk.storage.entity.StoragePo;
import com.monk.storage.mapper.StorageMapper;
import com.monk.storage.service.IStorageService;
import org.springframework.stereotype.Service;

@Service
public class StorageServiceImpl extends ServiceImpl<StorageMapper, StoragePo> implements IStorageService {
}
