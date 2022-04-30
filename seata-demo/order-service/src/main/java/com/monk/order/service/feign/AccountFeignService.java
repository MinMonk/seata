package com.monk.order.service.feign;

import com.monk.common.entity.JsonVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @author monk
 */
@FeignClient(value = "account-service")
public interface AccountFeignService {

    @GetMapping(value = "api/account/decrease")
    JsonVo decrease(@RequestParam("userId") Long userId, @RequestParam("money")BigDecimal count);
}
