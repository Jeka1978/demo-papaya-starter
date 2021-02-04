package com.papayastarterexample.demo;

import javax.annotation.PostConstruct;

/**
 * @author Evgeny Borisov
 */

public class KillerBean {


    @PostConstruct
    public void killServer(){
        System.out.println("You are a ROBOT, I'll terminate you");
    }
}
