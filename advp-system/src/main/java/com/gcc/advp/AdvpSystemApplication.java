package com.gcc.advp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author 40810
 */
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class AdvpSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdvpSystemApplication.class, args);
    }

}
