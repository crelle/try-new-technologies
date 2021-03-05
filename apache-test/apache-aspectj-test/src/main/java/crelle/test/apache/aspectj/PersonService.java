package crelle.test.apache.aspectj;

import org.springframework.stereotype.Service;

/**
 * @author:crelle
 * @className:PersonService
 * @version:1.0.0
 * @date:2021/3/5
 * @description:XX
 **/
@Service
public class PersonService {

    public Person buildPerson(){
        Person person = new Person();
        person.setAge("10");
        person.setName("张三");
        person.setCity("南京");
        return person;
    }
}
