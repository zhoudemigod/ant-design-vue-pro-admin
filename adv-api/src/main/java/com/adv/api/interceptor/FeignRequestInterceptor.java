package com.adv.api.interceptor;

import cn.hutool.core.util.ObjectUtil;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.apache.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 使用 Feign进行远程调用时，先经过此拦截器，在此拦截器中将请求头带上访问令牌
 */
@Component
public class FeignRequestInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        // 通过RequestContextHolder工具来获取请求相关变量
        ServletRequestAttributes attributes =
                (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        if(attributes != null) {
            // 获取请求对象
            HttpServletRequest request = attributes.getRequest();
            String token = request.getHeader(HttpHeaders.AUTHORIZATION);
            // Bearer xxx
            if(ObjectUtil.isNotEmpty(token)) {
                // 在使用feign远程调用时，请求头就会带上访问令牌
                requestTemplate.header(HttpHeaders.AUTHORIZATION, token);
            }
        }
    }
}
