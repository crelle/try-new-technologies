package crelle.test.springframework.beans.factory.annotation.annotationtypes.resourcevsinjectvsautowired;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author:crelle
 * @className:AnimalKeeper
 * @version:1.0.0
 * @date:2020/9/23
 * @description: cenario 1 : Inject using Interface type – Using @Resource or @Inject or @Autowired
 **/
@Component
public class AnimalKeeper1 {


    @Resource
    private  Animal animal;

//    @Inject
//    private  Animal animal;
//

//    @Autowired
//    private  Animal animal;

    public Animal getAnimal() {
        return animal;
    }
}
