package crelle.test.aspectj.afterthrowing;

import org.springframework.stereotype.Component;

/**
 * @author:crelle
 * @className:Operation
 * @version:1.0.0
 * @date:2020/9/21
 * @description:XX
 **/
@Component(value = "afterthrowingOperation")
public class Operation {

    public void validate(int age)throws Exception{
        if(age<18){
            throw new ArithmeticException("Not valid age");
        }else{
            System.out.println("Thanks for vote");
        }
    }
}
