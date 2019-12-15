package com.springmedia;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@ComponentScan
@EnableAutoConfiguration
@EnableAsync
public class Application {
	
	
	
    public static void main(String[] args) {
    	new SpringApplicationBuilder(Application.class)
        .properties("spring.config.name=application,remote-services")
        .run(args);
    }
    
    
}
