package com.crelle.mockito;

import org.junit.Test;

import java.util.List;

import static org.mockito.Mockito.*;

/**
 * @author:crelle
 * @className:Test1
 * @version:1.0.0
 * @date:2021/2/20
 * @description:XX
 **/
public class Test1 {

    @Test
    public void test1() {
        //create mock
        List mockedList = mock(List.class);
        //use mock object
        mockedList.add("one");
        mockedList.clear();
        //验证add方法是否在前面被调用了一次，且参数为“one”。clear方法同样。
        verify(mockedList).add("one");
        verify(mockedList).clear();
        //下面的验证会失败。因为没有调用过add("two")。
//        verify(mockedList).add("two");
    }
}
