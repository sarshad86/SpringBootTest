package com.home.test.rest;

/**
 * Created by Sara on 2018/09/14.
 */
public class MockController {

    private TestController testController;

    public MockController(TestController testController){
        this.testController = testController;
    }

    public void test() {
        testController.test();
    }
}
