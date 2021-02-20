package com.crelle.junit.ignoretest;

import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * @author:crelle
 * @className:TestJunit
 * @version:1.0.0
 * @date:2021/2/20
 * @description:XX
 **/
public class TestJunit {

    String message = "Robert";
    MessageUtil messageUtil = new MessageUtil(message);

    @Ignore
    @Test
    public void testPrintMessage() {
        System.out.println("Inside testPrintMessage()");
        message = "Robert";
        assertEquals(message,messageUtil.printMessage());
    }

    @Test
    public void testSalutationMessage() {
        System.out.println("Inside testSalutationMessage()");
        message = "Hi!" + "Robert";
        assertEquals(message,messageUtil.salutationMessage());
    }
}
