package com.adv.util.base.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Setter
@Getter
@Component
@ConfigurationProperties(prefix = "com.adv.util.base")
public class AdvProperties implements Serializable {

    // 会将 AdvProperties.aliyun 下的配置绑定到 AliyunProperties 对象属性上
    private AliyunProperties aliyun;

}
