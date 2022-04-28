package com.monk.common.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author monk
 */
@Data
public class BasePo {
    private Boolean validFlag;
    private Date paymentTime;
    private Long createUserId;
    private Date createTime;
    private Long updateUserId;
    private Date updateTime;
}
