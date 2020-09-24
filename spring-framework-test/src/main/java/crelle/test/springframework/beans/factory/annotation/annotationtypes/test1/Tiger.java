package crelle.test.springframework.beans.factory.annotation.annotationtypes.test1;

import org.springframework.stereotype.Component;

/**
 * @author:crelle
 * @className:Tiger
 * @version:1.0.0
 * @date:2020/9/23
 * @description:XX
 **/
@Component
public class Tiger implements Animal {
    @Override
    public String type() {
        return "Tiger";
    }
}
