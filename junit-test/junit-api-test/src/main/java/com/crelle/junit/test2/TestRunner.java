package com.crelle.junit.test2;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * @author:crelle
 * @className:TestRunner
 * @version:1.0.0
 * @date:2021/2/20
 * @description:XX
 **/
public class TestRunner {

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(TestEmployeeDetails.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println(result.wasSuccessful());
    }
}
