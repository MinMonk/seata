CREATE TABLE `t_order`  (
   `id` bigint NOT NULL AUTO_INCREMENT,
   `order_no` varchar(50) NOT NULL COMMENT '订单编号',
   `product_id` varchar(50) NOT NULL COMMENT '商品ID',
   `status` tinyint(1) NOT NULL COMMENT '订单状态',
   `payment_time` datetime(0) NULL COMMENT '支付时间',
   `create_user_id` int NULL COMMENT '创建人',
   `create_time` datetime(0) NULL COMMENT '创建时间',
   `update_user_id` int NULL COMMENT '更新人',
   `update_time` datetime(0) NULL COMMENT '更新时间',
   PRIMARY KEY (`id`)
);