package com.monk.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


/**
 * Hello world!
 *
 * @author monk
 */
@EnableFeignClients(basePackages = "com.monk.order.service.feign")
@EnableDiscoveryClient
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@MapperScan("com.monk.order.mapper")
public class OrderServer
{
    public static void main( String[] args )
    {
        SpringApplication.run(OrderServer.class, args);
        System.out.println("订单服务启动成功....");
    }
}
