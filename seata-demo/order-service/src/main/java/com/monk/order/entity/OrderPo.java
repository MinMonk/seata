package com.monk.order.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.monk.common.entity.BasePo;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author monk
 */
@TableName("t_order")
@Data
@NoArgsConstructor
public class OrderPo extends BasePo {

    @TableId
    private Long id;

    private Long userId;

    private String productId;

    private Integer count;

    private BigDecimal money;

    private Integer status; //订单状态：0：创建中；1：已完结
}
