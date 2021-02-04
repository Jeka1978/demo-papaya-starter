package com.papayastarterexample.demo;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Evgeny Borisov
 */

public class ExceptionHandlerAspect implements MethodInterceptor {

    @Autowired
    private MailSender mailSender;


//    private Map<MariaDbException,Void> dbExceptions = new WeakHashMap<>();


    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        try {
            return methodInvocation.proceed();
        } catch (MariaDbException ex) {

//            if (!dbExceptions.containsKey(ex)) {
                mailSender.sendMailToDba(ex);
//                dbExceptions.put(ex,null);
//            }

            throw ex;
        }
    }
}






