package crelle.test.springframework.beans.factory.annotation.annotationtypes.test1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author:crelle
 * @className:AnimalKeeper5
 * @version:1.0.0
 * @date:2020/9/23
 * @description: Scenario 5 : Using Qualifier with incorrect qualifier name , but with correct field name
 *                            Using @Resource – here Match by Name takes higher precedence.
 **/
@Component
public class AnimalKeeper5_1 {

    @Resource
    @Qualifier(value = "incorrect")
    private Animal tiger;

    public Animal getTiger() {
        return tiger;
    }
}
