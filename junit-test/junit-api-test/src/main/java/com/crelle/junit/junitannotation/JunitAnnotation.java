package com.crelle.junit.junitannotation;

import org.junit.*;

/**
 * @author:crelle
 * @className:JunitAnnotation
 * @version:1.0.0
 * @date:2021/2/20
 * @description:XX
 **/
public class JunitAnnotation {


    //execute before class
    @BeforeClass
    public static void beforeClass() {
        System.out.println("in before class");
    }

    //execute after class
    @AfterClass
    public static void  afterClass() {
        System.out.println("in after class");
    }

    //execute before test
    @Before
    public void before() {
        System.out.println("in before");
    }

    //execute after test
    @After
    public void after() {
        System.out.println("in after");
    }

    //test case
    @Test
    public void test() {
        System.out.println("in test");
    }

    //test case ignore and will not execute
    @Ignore
    public void ignoreTest() {
        System.out.println("in ignore test");
    }

}
