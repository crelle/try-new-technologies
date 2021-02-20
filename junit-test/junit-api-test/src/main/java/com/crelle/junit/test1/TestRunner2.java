package com.crelle.junit.test1;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * @author:crelle
 * @className:TestRunner2
 * @version:1.0.0
 * @date:2021/2/20
 * @description:XX
 **/
public class TestRunner2 {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(TestJunit2.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println(result.wasSuccessful());
    }
}
