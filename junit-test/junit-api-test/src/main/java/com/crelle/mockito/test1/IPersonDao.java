package com.crelle.mockito.test1;

/**
 * @author:crelle
 * @className:IPersonDao
 * @version:1.0.0
 * @date:2021/2/21
 * @description:XX
 **/
public interface IPersonDao {
    Person getPerson(int id);
    boolean update(Person person);
}
