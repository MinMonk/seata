package com.monk.order.service.feign;

import com.monk.common.entity.JsonVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author monk
 */
@FeignClient(value = "storage-service")
public interface StorageFeignService {

    @GetMapping(value = "api/storage/decrease")
    JsonVo decrease(@RequestParam("productId") String productId, @RequestParam("count") Integer count);
}
