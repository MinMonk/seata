package com.monk.order.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.monk.order.entity.OrderPo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author monk
 */
@Mapper
public interface OrderMapper extends BaseMapper<OrderPo> {

}
