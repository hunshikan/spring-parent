package com.emily.infrastructure.autoconfigure.request;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Emily
 * @description: 拦截器属性配置类
 * @create: 2020/03/19
 */
@ConfigurationProperties(prefix = RequestProperties.PREFIX)
public class RequestProperties {
    /**
     * 属性配置前缀
     */
    public static final String PREFIX = "spring.emily.request";
    /**
     * 组件开关
     */
    private boolean enabled;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
