package com.crelle.junit.test1;


import org.junit.Assert;
import org.junit.Test;

/**
 * @author:crelle
 * @className:TestJunit1
 * @version:1.0.0
 * @date:2021/2/20
 * @description:XX
 **/
public class TestJunit1 {

    @Test
    public void testAdd() {
        //test data
        int num = 5;
        String temp = null;
        String str = "Junit is working fine";

        //check for equality
        Assert.assertEquals("Junit is working fine", str);

        //check for false condition
        Assert.assertFalse(num > 3);

        //check for not null value
        Assert.assertNotNull(str);
    }
}
