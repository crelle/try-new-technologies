package crelle.test.aspectj.afterreturning;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author:crelle
 * @className:Operation
 * @version:1.0.0
 * @date:2020/9/21
 * @description:XX
 **/
@Component(value = "afterreturningOperation")
public class Operation {

    public int m(){
        System.out.println("m() method invoked");
        return 2;
    }
    public int k(){
        System.out.println("k() method invoked");
        return 3;
    }
}
