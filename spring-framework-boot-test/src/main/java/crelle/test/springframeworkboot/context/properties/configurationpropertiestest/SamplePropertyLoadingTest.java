package crelle.test.springframeworkboot.context.properties.configurationpropertiestest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author:crelle
 * @className:SamplePropertyLoadingTest
 * @version:1.0.0
 * @date:2020/9/27
 * @description:XX
 **/
@Component
public class SamplePropertyLoadingTest {

    @Value("${prefix.stringProp1}")
    private String stringProp1;

    public String getStringProp1() {
        return stringProp1;
    }
}
