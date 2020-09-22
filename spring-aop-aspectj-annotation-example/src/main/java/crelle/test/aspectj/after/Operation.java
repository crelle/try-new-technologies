package crelle.test.aspectj.after;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

/**
 * @author:crelle
 * @className:Operation
 * @version:1.0.0
 * @date:2020/9/21
 * @description:XX
 **/
@Component(value = "afterOperation")
public class Operation {

    public void msg(){
        System.out.println("msg method invoked");
    }

    public int m(){
        System.out.println("m method invoked");return 2;
    }

    public int k(){
        System.out.println("k method invoked");return 3;
    }
}
