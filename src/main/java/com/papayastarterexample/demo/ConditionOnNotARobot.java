package com.papayastarterexample.demo;/**
 * @author Evgeny Borisov
 */

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Conditional({OnNotARobotCondition.class})
public @interface ConditionOnNotARobot {
}
