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

    @Autowired
    private StarterProps starterProps;


//    private Map<MariaDbException,Void> dbExceptions = new WeakHashMap<>();


    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        try {
            return methodInvocation.proceed();
        } catch (Exception ex) { //todo homework - make the exception configurable from outside

            if(ex.getClass().getName().equals(starterProps.getExceptionClassName()))
//            if (!dbExceptions.containsKey(ex)) {
                mailSender.sendMailToDba(ex);
//                dbExceptions.put(ex,null);
//            }

            throw ex;
        }
    }
}






