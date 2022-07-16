package com.adv.upms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author 40810
 */
@SpringBootApplication
@EnableDiscoveryClient
public class AdvUpmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdvUpmsApplication.class, args);
    }

}
