package com.crelle.junit.test1;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

/**
 * @author:crelle
 * @className:TestJunit2
 * @version:1.0.0
 * @date:2021/2/20
 * @description:XX
 **/
public class TestJunit2 extends TestCase {
    protected double fValue1;
    protected double fValue2;

    @Before
    public void setUp() {
        fValue1= 2.0;
        fValue2= 3.0;
    }

    @Test
    public void testAdd() {
        //count the number of test cases
        System.out.println("No of Test Case = "+ this.countTestCases());

        //test getName
        String name= this.getName();
        System.out.println("Test Case Name = "+ name);

        //test setName
        this.setName("testNewAdd");
        String newName= this.getName();
        System.out.println("Updated Test Case Name = "+ newName);
    }
    //tearDown used to close the connection or clean up activities
    public void tearDown(  ) {
    }
}
