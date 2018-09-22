package com.home.test.config.load;

import com.home.test.rest.TestController;
import com.home.test.rest.MockController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by Sara on 2018/09/14.
 */
@Configuration
@Import(TestConfig.class)
@ConditionalOnProperty("channels.mockserver")
public class MockConfig {

    @Autowired
    private TestController testController;

    @Bean
    public MockController mockController() {
        return new MockController(testController);
    }
}
