package com.monk.storage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Hello world!
 *
 * @author monk
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.monk.storage.mapper")
public class StorageServer
{
    public static void main( String[] args )
    {
        SpringApplication.run(StorageServer.class, args);
    }
}
