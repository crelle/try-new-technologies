package com.crelle.mockito.test1;

/**
 * @author:crelle
 * @className:PersonService
 * @version:1.0.0
 * @date:2021/2/21
 * @description:XX
 **/
public class PersonService {

    private final IPersonDao personDao;

    public PersonService(IPersonDao personDao) {
        this.personDao = personDao;
    }

    public boolean update(int id, String name) {
        Person person = personDao.getPerson(id);
        if (person == null) {
            return false;
        }
        Person personUpdate = new Person(person.getId(), name);
        return personDao.update(personUpdate);
    }
}
