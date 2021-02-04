package com.papayastarterexample.demo;

import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.*;

/**
 * @author Evgeny Borisov
 */
@Configuration
@EnableAspectJAutoProxy
@EnableConfigurationProperties(StarterProps.class)
@Import(AopExceptionConfiguration.class)
public class ExceptionHandlingConfig {


   /* @Bean
    @ConditionOnNotARobot
    public KillerBean killerBean(){
        return new KillerBean();
    }*/


    @Bean
    public MailSender mailSender(){
        return new MailSenderImpl();
    }











}
















