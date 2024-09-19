package com.tegshigzugder.explorenote;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ExplorenoteApplication {

    public static void main(String[] args) {
        var ctx = SpringApplication.run(ExplorenoteApplication.class, args);
        // getBeanNames(ctx);
    }

    private static void getBeanNames(ConfigurableApplicationContext ctx) {
        System.out.println("-------------------------------");
        System.out.println("Let's inspect the beans provided by Spring Boot:");
        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }
        System.out.println("-------------------------------");
    }
}
