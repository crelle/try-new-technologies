package com.crelle.junit.test1;

import junit.framework.TestResult;
import junit.framework.TestSuite;

/**
 * @author:crelle
 * @className:JunitTestSuite
 * @version:1.0.0
 * @date:2021/2/20
 * @description:XX
 **/
public class JunitTestSuite {
    public static void main(String[] a) {
        // add the test's in the suite
        TestSuite suite = new TestSuite(TestJunit1.class, TestJunit2.class, TestJunit3.class );
        TestResult result = new TestResult();
        suite.run(result);
        System.out.println("Number of test cases = " + result.runCount());
        System.out.println("测试套件是否成功:"+result.wasSuccessful());
        System.out.println("测试用例失败的数量："+result.errorCount());
    }
}
