package com.home.test.config.load;

import com.home.test.rest.TestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 * Created by Sara on 2018/09/14.
 */
@Configuration
@PropertySource("classpath:test.properties")
public class TestConfig {

    @Autowired
    private Environment environment;

    @Bean
    public TestController globalController(@Value("${global.count}") int count){
        return new TestController(Integer.parseInt(environment.getProperty("test.number")), count);
    }
}
