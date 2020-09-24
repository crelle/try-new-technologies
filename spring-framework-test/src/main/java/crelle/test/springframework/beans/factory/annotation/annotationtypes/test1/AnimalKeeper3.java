package crelle.test.springframework.beans.factory.annotation.annotationtypes.test1;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author:crelle
 * @className:AnimalKeeper2
 * @version:1.0.0
 * @date:2020/9/23
 * @description: Scenario 3 : Injecting using field name:- Using @Resource or @Inject or @Autowired
 **/
@Component
public class AnimalKeeper3 {

    @Resource
    private Animal tiger;

    // @Inject
    // private Animal tiger;

    // @Autowired
    // private Animal tiger;


    public Animal getTiger() {
        return tiger;
    }
}
