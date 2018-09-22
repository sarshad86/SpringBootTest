package com.home.test;

import com.home.test.config.load.MockConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

/**
 * Created by Sara on 2018/09/13.
 */
@SpringBootApplication
@ComponentScan("com.home.test")
@Import({MockConfig.class})
public class Launcher extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(Launcher.class, args);
    }
}
