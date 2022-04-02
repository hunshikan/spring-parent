package com.emily.infrastructure.autoconfigure.response;

import com.emily.infrastructure.autoconfigure.response.handler.ResponseHttpEntityMethodReturnValueHandler;
import com.emily.infrastructure.autoconfigure.response.handler.ResponseHttpHeadersReturnValueHandler;
import com.emily.infrastructure.autoconfigure.response.handler.ResponseMethodReturnValueHandler;
import com.emily.infrastructure.logger.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.mvc.method.annotation.HttpEntityMethodProcessor;
import org.springframework.web.servlet.mvc.method.annotation.HttpHeadersReturnValueHandler;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Emily
 * @Description: 控制器返回值配置处理类
 * @Version: 1.0
 */
@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties(ResponseWrapperProperties.class)
@ConditionalOnProperty(prefix = ResponseWrapperProperties.PREFIX, name = "enabled", havingValue = "true", matchIfMissing = true)
public class ResponseWrapperAutoConfiguration implements InitializingBean, DisposableBean {

    private static final Logger logger = LoggerFactory.getLogger(ResponseWrapperAutoConfiguration.class);

    @Bean
    public Object initResponseWrapper(RequestMappingHandlerAdapter handlerAdapter, ResponseWrapperProperties properties) {
        List<HandlerMethodReturnValueHandler> handlers = handlerAdapter.getReturnValueHandlers().stream().map(valueHandler -> {
            if (valueHandler instanceof RequestResponseBodyMethodProcessor) {
                return new ResponseMethodReturnValueHandler(valueHandler, properties);
            }
            if (valueHandler instanceof HttpEntityMethodProcessor) {
                return new ResponseHttpEntityMethodReturnValueHandler(valueHandler, properties);
            }
            if (valueHandler instanceof HttpHeadersReturnValueHandler) {
                return new ResponseHttpHeadersReturnValueHandler(valueHandler);
            }
            return valueHandler;
        }).collect(Collectors.toList());

        handlerAdapter.setReturnValueHandlers(handlers);
        return "UNSET";
    }

    @Override
    public void destroy() throws Exception {
        logger.info("<== 【销毁--自动化配置】----Response返回值包装组件【ResponseWrapperAutoConfiguration】");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        logger.info("==> 【初始化--自动化配置】----Response返回值包装组件【ResponseWrapperAutoConfiguration】");
    }
}
