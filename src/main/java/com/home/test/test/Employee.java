package com.home.test.test;

/**
 * Created by Sara on 2019/06/17.
 */
public class Employee {
    private String a;
    private int i;
    public Employee(String a, int i) {
        this.a = a;
        this.i = i;
    }

    public int getSalary() {
        return 50*i;
    }
}
