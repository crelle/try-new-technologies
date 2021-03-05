package com.crelle.mockito.test1;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

/**
 * @author:crelle
 * @className:PersonServiceTest
 * @version:1.0.0
 * @date:2021/2/21
 * @description:XX
 **/
public class PersonServiceTest {

    private IPersonDao mockDao;

    private PersonService personService;

    @Before
    public void before() throws Exception {
        //手动构造mock对象
        mockDao = mock(IPersonDao.class);
        when(mockDao.getPerson(1)).thenReturn(new Person(1,"mst"));
        when(mockDao.update(isA(Person.class))).thenReturn(true);

        personService = new PersonService(mockDao);
    }

    @After
    public void after() throws Exception {
    }

    /**
     *
     * Method: update(int id, String name)
     *
     */
    @Test
    public void testUpdate() throws Exception {
        boolean result = personService.update(1,"md");

        assertTrue(result);

        //验证是否执行过一次getPerson(1)
        verify(mockDao,times(1)).getPerson(eq(1));
        //验证是否执行过一次update
        verify(mockDao,times(1)).update(isA(Person.class));
    }

    @Test
    public void testUpdateNotFind() throws Exception {
        boolean result = personService.update(2, "md");

        assertFalse( result);

        //验证是否执行过一次getPerson(1)
        verify(mockDao, times(1)).getPerson(eq(2));
        //验证是否执行过一次update
        verify(mockDao, never()).update(isA(Person.class));
    }

    //注解构造mock对象
    @Mock
    List list;

    public PersonServiceTest(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testList(){
        when(list.add(isA(Object.class))).thenReturn(true);
        list.add(2);
        list.add(5);
        boolean re = list.add(1);
        assertTrue(re);
    }

}