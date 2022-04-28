-- undo-log表,客户端均需要执行
CREATE TABLE IF NOT EXISTS `undo_log`
(
    `branch_id`     BIGINT       NOT NULL COMMENT 'branch transaction id',
    `xid`           VARCHAR(128) NOT NULL COMMENT 'global transaction id',
    `context`       VARCHAR(128) NOT NULL COMMENT 'undo_log context,such as serialization',
    `rollback_info` LONGBLOB     NOT NULL COMMENT 'rollback info',
    `log_status`    INT(11)      NOT NULL COMMENT '0:normal status,1:defense status',
    `log_created`   DATETIME(6)  NOT NULL COMMENT 'create datetime',
    `log_modified`  DATETIME(6)  NOT NULL COMMENT 'modify datetime',
    UNIQUE KEY `ux_undo_log` (`xid`, `branch_id`)
) ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARSET = utf8 COMMENT ='AT transaction mode undo table';


-- 订单表,在order-service项目中执行
CREATE TABLE `t_order`  (
   `id` bigint NOT NULL AUTO_INCREMENT,
   `order_no` varchar(50) NOT NULL COMMENT '订单编号',
   `product_id` varchar(50) NOT NULL COMMENT '商品ID',
   `status` tinyint(1) NOT NULL COMMENT '订单状态',
   `payment_time` datetime(0) NULL COMMENT '支付时间',
   `valid_flag` tinyint(1) NOT NULL default 1 COMMENT '数据有效性标识',
   `create_user_id` int NULL COMMENT '创建人',
   `create_time` datetime(0) NULL COMMENT '创建时间',
   `update_user_id` int NULL COMMENT '更新人',
   `update_time` datetime(0) NULL COMMENT '更新时间',
   PRIMARY KEY (`id`)
);

-- 库存表,在storage-service项目中执行
CREATE TABLE `t_storage`  (
    `id` bigint NOT NULL AUTO_INCREMENT,
    `product_id` varchar(50) NOT NULL COMMENT '商品ID',
    `total` int(5) not null comment '库存总量',
    `used` int(5) not null comment '已用库存',
    `residue` int(5) not null comment '剩余库存',
    `valid_flag` tinyint(1) NOT NULL default 1 COMMENT '数据有效性标识',
    `create_user_id` int NULL COMMENT '创建人',
    `create_time` datetime(0) NULL COMMENT '创建时间',
    `update_user_id` int NULL COMMENT '更新人',
    `update_time` datetime(0) NULL COMMENT '更新时间',
    PRIMARY KEY (`id`)
);


-- 库存表,在storage-service项目中执行
CREATE TABLE `t_account`  (
    `id` bigint NOT NULL AUTO_INCREMENT,
    `userId` bigint NOT NULL COMMENT '用户ID',
    `total` decimal(5, 2) not null comment '总额度',
    `used` decimal(5, 2) not null comment '已用额度',
    `residue` decimal(5, 2) not null comment '剩余额度',
    `valid_flag` tinyint(1) NOT NULL default 1 COMMENT '数据有效性标识',
    `create_user_id` int NULL COMMENT '创建人',
    `create_time` datetime(0) NULL COMMENT '创建时间',
    `update_user_id` int NULL COMMENT '更新人',
    `update_time` datetime(0) NULL COMMENT '更新时间',
    PRIMARY KEY (`id`)
);