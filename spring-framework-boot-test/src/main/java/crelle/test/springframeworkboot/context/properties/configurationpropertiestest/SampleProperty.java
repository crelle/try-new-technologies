package crelle.test.springframeworkboot.context.properties.configurationpropertiestest;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.Map;

/**
 * @author:crelle
 * @className:SampleProperty
 * @version:1.0.0
 * @date:2020/9/27
 * @description:XX
 **/
@ConfigurationProperties(prefix = "prefix")
@Component
@Data
public class SampleProperty {

    private String stringProp1;
    private String stringProp2;
    @Max(99)
    @Min(0)
    private Integer intProp1;
    private List<String> listProp;
    private Map<String, String> mapProp;
}
