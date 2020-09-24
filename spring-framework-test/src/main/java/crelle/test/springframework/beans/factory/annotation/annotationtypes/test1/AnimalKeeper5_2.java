package crelle.test.springframework.beans.factory.annotation.annotationtypes.test1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.inject.Inject;

/**
 * @author:crelle
 * @className:AnimalKeeper5_2
 * @version:1.0.0
 * @date:2020/9/23
 * @description: Using @Inject or @Autowired:Qualifier has higher precedence over field name.
 **/
@Component
public class AnimalKeeper5_2 {
    @Qualifier(value = "lion")
    @Autowired
    private Animal tiger;

// @Autowired
// @Qualifier(“incorrect”)
// private Animal tiger;

    public Animal getAnimal() {
        return tiger;
    }
}
