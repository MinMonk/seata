package com.monk.order.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.monk.common.entity.BasePo;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author monk
 */
@TableName("t_order")
@Data
@NoArgsConstructor
public class OrderPo extends BasePo {

    @TableId
    private Long id;
    private String orderNo;
    private String productId;
    private Integer status;
}
