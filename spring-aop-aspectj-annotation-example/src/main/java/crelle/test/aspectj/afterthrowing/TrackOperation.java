package crelle.test.aspectj.afterthrowing;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author:crelle
 * @className:TrackOperation
 * @version:1.0.0
 * @date:2020/9/21
 * @description:XX
 **/
@Aspect
@Component(value = "afterthrowingTrackOperation")
public class TrackOperation {

    @AfterThrowing(
            pointcut = "execution(* Operation.*(..))",
            throwing= "error")
    public void myadvice(JoinPoint jp, Throwable error)//it is advice
    {
        System.out.println("additional concern");
        System.out.println("Method Signature: "  + jp.getSignature());
        System.out.println("Method params:" + jp.getArgs().toString());
        System.out.println("Exception is: "+error);
        System.out.println("end of after throwing advice...");
    }
}
