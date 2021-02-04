package com.papayastarterexample.demo;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import javax.swing.*;

/**
 * @author Evgeny Borisov
 */
public class OnNotARobotCondition implements Condition {

    private static Boolean answer;

    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {


        if (answer == null) {
            String answer = JOptionPane.showInputDialog("2+2=?");

            this.answer = !answer.equals("4");
        }
        return this.answer;
    }
}
