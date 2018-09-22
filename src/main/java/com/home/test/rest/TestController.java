package com.home.test.rest;

/**
 * Created by Sara on 2018/09/14.
 */
public class TestController {

    private final int number, count;

    public TestController(int number, int count){
        this.number = number;
        this.count = count;
    }

    public void test() {
        for (int i = 0; i < count; i++) {
            System.out.println(number);
        }
    }
}
