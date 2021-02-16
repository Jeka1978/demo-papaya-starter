package com.papayastarterexample.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @author Evgeny Borisov
 */
public class ProfileAutoRegistrarEnvironmentPostProcessor implements EnvironmentPostProcessor, Ordered {
    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        if (getTemperature() > -50) {
            environment.addActiveProfile("WINTER_IS_COMING");
        }else {
            environment.addActiveProfile("WINTER_IS_HERE");
        }
    }

    private int getTemperature() {
        return -20;
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
