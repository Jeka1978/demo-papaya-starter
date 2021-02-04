package com.papayastarterexample.demo;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Method;

/**
 * @author Evgeny Borisov
 */
public class CustomPointcut extends DynamicMethodMatcherPointcut {

    @Autowired
    private StarterProps starterProps;

    @Override
    public boolean matches(Method method, Class<?> aClass, Object... objects) {

        return true;
    }

    @Override
    public ClassFilter getClassFilter() {
        return new ClassFilter() {
            @Override
            public boolean matches(Class<?> aClass) {
                return aClass.getPackage().getName().contains(starterProps.getPackagesToScan());
            }
        };
    }
}
