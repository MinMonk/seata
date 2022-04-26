package com.monk.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Hello world!
 *
 * @author monk
 */
@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.monk.order.mapper")
public class OrderServer
{
    public static void main( String[] args )
    {
        SpringApplication.run(OrderServer.class, args);
        System.out.println("订单服务启动成功....");
    }
}
