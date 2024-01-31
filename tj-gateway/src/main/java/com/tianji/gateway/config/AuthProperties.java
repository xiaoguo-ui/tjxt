package com.tianji.gateway.config;

import lombok.Data;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * 存储与认证相关的配置属性。
 * InitializingBean：在 Spring 创建这个类的实例并设置好所有属性后，会调用 afterPropertiesSet 方法。
 */
@Data
@Component
@ConfigurationProperties(prefix = "tj.auth")
public class AuthProperties implements InitializingBean {

    private Set<String> excludePath;

    @Override
    // 添加默认不拦截的路径
    public void afterPropertiesSet() throws Exception {
        excludePath.add("/error/**");
        excludePath.add("/jwks");
        excludePath.add("/accounts/login");
        excludePath.add("/accounts/admin/login");
        excludePath.add("/accounts/refresh");
    }
}
