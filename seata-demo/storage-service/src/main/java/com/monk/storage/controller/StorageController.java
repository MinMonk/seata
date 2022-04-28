package com.monk.storage.controller;

import com.monk.common.entity.JsonVo;
import com.monk.storage.entity.StoragePo;
import com.monk.storage.service.IStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author monk
 */
@RestController
@RequestMapping("/storage")
public class StorageController {

    @Autowired
    private IStorageService storageService;

    @PostMapping("/create")
    public JsonVo create(@RequestBody StoragePo order){
        return new JsonVo().data(storageService.save(order));
    }
}
