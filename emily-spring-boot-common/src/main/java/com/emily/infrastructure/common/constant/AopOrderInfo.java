package com.emily.infrastructure.common.constant;

/**
 * @author Emily
 * @Description: 定义优先级顺序
 * @create: 2020/3/23
 */
public class AopOrderInfo {
    /**
     * API请求切面
     */
    public static final int REQUEST = 400;
    /**
     * API请求拦截器
     */
    public static final int REQUEST_INTERCEPTOR = 410;
    /**
     * feign正常日志
     */
    public static final int FEIGN = 800;
    /**
     * Mybatis日志漆面
     */
    public static final int MYBATIS = 850;
    /**
     * MYBATIS拦截器
     */
    public static final int MYBATIS_INTERCEPTOR = 852;
    /**
     * 数据源切面
     */
    public static final int DATASOURCE = 900;
    /**
     * 数据库AOP切面拦截器
     */
    public static final int DATASOURCE_INTERCEPTOR = 910;
    /**
     * RestTemplate请求拦截器优先级
     */
    public static final int HTTP_CLIENT_INTERCEPTOR = 1000;
    /**
     * Feign日志拦截器优先级顺序
     */
    public static final int FEIGN_INTERCEPTOR = 1100;

}
