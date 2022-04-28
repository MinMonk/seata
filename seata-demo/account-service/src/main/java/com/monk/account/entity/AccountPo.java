package com.monk.account.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.monk.common.entity.BasePo;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author monk
 */
@TableName("t_account")
@Data
public class AccountPo extends BasePo {

    @TableId
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 总额度
     */
    private BigDecimal total;

    /**
     * 已用额度
     */
    private BigDecimal used;

    /**
     * 剩余额度
     */
    private BigDecimal residue;
}
