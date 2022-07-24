package com.gcc.advp.utils.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Setter
@Getter
@Component
@ConfigurationProperties(prefix = "com.gcc")
public class AdvpProperties implements Serializable {

    private AliyunProperties aliyun;

}
