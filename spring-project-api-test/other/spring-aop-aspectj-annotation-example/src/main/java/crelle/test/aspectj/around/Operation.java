package crelle.test.aspectj.around;

import org.springframework.stereotype.Component;

/**
 * @author:crelle
 * @className:Operation
 * @version:1.0.0
 * @date:2020/9/21
 * @description:XX
 **/
@Component(value = "aroundOperation")
public class Operation {

    public void msg(){
        System.out.println("msg() is invoked");
    }
    public void display(){
        System.out.println("display() is invoked");
    }
}
