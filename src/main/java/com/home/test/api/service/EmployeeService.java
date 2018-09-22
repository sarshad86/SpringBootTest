package com.home.test.api.service;

import com.home.test.api.model.Employee;

import java.util.List;

/**
 * Created by Sara on 2018/09/15.
 */
public interface EmployeeService {

    Employee getEmployeeByName(String name);

    List<Employee> getAllEmployees();

    void deleteAll();

    Employee save(Employee employee);

}
