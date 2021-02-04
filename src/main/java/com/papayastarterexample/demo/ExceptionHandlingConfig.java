package com.papayastarterexample.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author Evgeny Borisov
 */
@Configuration
@EnableAspectJAutoProxy
public class ExceptionHandlingConfig {

    @Bean
    public MailSender mailSender(){
        return new MailSenderImpl();
    }

    @Bean
    public ExceptionHandlerAspect exceptionHandlerAspect(){
        return new ExceptionHandlerAspect();
    }
}
