package com.papayastarterexample.demo;

import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Evgeny Borisov
 */
@Configuration
@ConditionalOnProperty(value = "exceptions.packages-to-scan")
public class AopExceptionConfiguration {
    @Bean
    public ExceptionHandlerAspect exceptionHandlerAspect(){
        return new ExceptionHandlerAspect();
    }

    @Bean
    public CustomPointcut myCustomPointcut(){
        return new CustomPointcut();
    }



    @Bean
    public DefaultPointcutAdvisor myDefaultPointcutAdvisor(){
        return new DefaultPointcutAdvisor(myCustomPointcut(), exceptionHandlerAspect());
    }
}
