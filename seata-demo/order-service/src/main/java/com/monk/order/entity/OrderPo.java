package com.monk.order.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author monk
 */
@TableName("t_order")
@Data
public class OrderPo {

    @TableId
    private Long id;
    private String orderNo;
    private String productId;
    private Integer status;
    private Date paymentTime;
    private Long createUserId;
    private Date createTime;
    private Long updateUserId;
    private Date updateTime;

}
