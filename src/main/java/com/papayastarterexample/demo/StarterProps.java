package com.papayastarterexample.demo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Evgeny Borisov
 */
@Data
@ConfigurationProperties(prefix = "exceptions")
public class StarterProps {
    private String packagesToScan;

    private int number;

    private String name;
}
