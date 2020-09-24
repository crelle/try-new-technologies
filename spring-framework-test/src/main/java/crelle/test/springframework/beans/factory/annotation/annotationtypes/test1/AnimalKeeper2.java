package crelle.test.springframework.beans.factory.annotation.annotationtypes.test1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.inject.Inject;

/**
 * @author:crelle
 * @className:AnimalKeeper1
 * @version:1.0.0
 * @date:2020/9/23
 * @description: Scenario 2 : Inject using field type as concrete class:- Using @Resource or @Inject or @Autowired
 **/
@Component
public class AnimalKeeper2 {

//    @Resource
//    private Tiger animal;

//     @Inject
//     private Tiger animal;

     @Autowired
     private Tiger animal;


    public Tiger getAnimal() {
        return animal;
    }
}
