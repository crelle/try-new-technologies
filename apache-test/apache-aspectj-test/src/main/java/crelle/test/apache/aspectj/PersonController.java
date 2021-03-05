package crelle.test.apache.aspectj;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author:crelle
 * @className:ControllerTest
 * @version:1.0.0
 * @date:2021/3/5
 * @description:XX
 **/
@RestController
@RequestMapping(value = "/test")
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping(value = "/getPerson" ,method = RequestMethod.GET)
    public Person getPerson(){
        return personService.buildPerson();
    }


}
