package crelle.test.springframework.beans.factory.annotation.annotationtypes.resourcevsinjectvsautowired;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author:crelle
 * @className:AnimalKeeper4
 * @version:1.0.0
 * @date:2020/9/23
 * @description: Scenario 4 : Using Qualifier with correct qualifier name:- Using @Resource or @Inject or @Autowired
 **/
@Component
public class AnimalKeeper4 {

    @Resource
    @Qualifier("tiger")
    private Animal animal;

    // @Inject
    // @Qualifier(“tiger”)
    // private Animal animal;

    // @Autowired
    // @Qualifier(“tiger”)
    // private Animal animal;


    public Animal getAnimal() {
        return animal;
    }
}
