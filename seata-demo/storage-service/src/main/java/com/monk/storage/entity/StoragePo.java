package com.monk.storage.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.monk.common.entity.BasePo;
import lombok.Data;

/**
 * @author monk
 */
@TableName("t_storage")
@Data
public class StoragePo extends BasePo {

    @TableId
    private Long id;

    /**
     * 产品id
     */
    private Long productId;

    /**
     * 总库存
     */
    private Integer total;

    /**
     * 已用库存
     */
    private Integer used;

    /**
     * 剩余库存
     */
    private Integer residue;
}
