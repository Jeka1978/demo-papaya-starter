package com.papayastarterexample.demo;

import lombok.SneakyThrows;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

/**
 * @author Evgeny Borisov
 */
@Aspect
public class ExceptionHandlerAspect {

    @Autowired
    private MailSender mailSender;


    private Map<MariaDbException,Void> dbExceptions = new WeakHashMap<>();


    @SneakyThrows
    @Around("execution(* com.papaya.aop_advanced_examples..*.*(..))")  //todo pointcut should be congigurable
    public Object handleMariaDbExceptions(ProceedingJoinPoint pjp) {
        try {
            return pjp.proceed();
        } catch (MariaDbException ex) {

            if (!dbExceptions.containsKey(ex)) {
                mailSender.sendMailToDba(ex);
                dbExceptions.put(ex,null);
            }

            throw ex;
        }
    }
}






