package com.crelle.mockito.test1;

/**
 * @author:crelle
 * @className:Person
 * @version:1.0.0
 * @date:2021/2/21
 * @description:XX
 **/
public class Person {

    private final int id;
    private final String name;
    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
}
