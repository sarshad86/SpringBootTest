package com.home.test;

import com.home.test.api.model.Employee;
import com.home.test.api.service.EmployeeService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by Sara on 2018/09/13.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = Launcher.class)
@WebAppConfiguration
//@TestPropertySource(
//        locations = "classpath:application.yml")
public class EmployeeRestControllerIntegrationTest {

    @Autowired
    private WebApplicationContext context;
//    @Autowired
//    private FilterChainProxy filterChainProxy;

    //    @Autowired
    private MockMvc mvc;

    @Autowired
    private EmployeeService employeeService;

    @Before
    public void setUp() {
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
//                .addFilter(filterChainProxy)
                .apply(springSecurity())
                .build();
    }

    @After
    public void resetDb() {
        employeeService.deleteAll();
    }

    @Test
    @WithMockUser(username = "sarshad", password = "123")
    public void givenEmployees_whenGetEmployees_thenStatus200()
            throws Exception {

        Employee employee = new Employee("bob");
        employeeService.save(employee);

//        mvc.perform(get("/api/employees").with(anonymous())
        mvc.perform(get("/api/employees")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].name", is("bob")));

        List<Employee> found = employeeService.getAllEmployees();
        assertThat(found).extracting(Employee::getName).containsOnly("bob");
    }
}
