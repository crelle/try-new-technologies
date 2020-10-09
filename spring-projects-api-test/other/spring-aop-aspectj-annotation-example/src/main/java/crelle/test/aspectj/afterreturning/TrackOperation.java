package crelle.test.aspectj.afterreturning;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author:crelle
 * @className:TrackOperation
 * @version:1.0.0
 * @date:2020/9/21
 * @description:XX
 **/
@Aspect
@Component(value = "afterreturningTrackOperation")
public class TrackOperation{

    @AfterReturning(pointcut = "execution(* Operation.*(..))",returning= "result")
    public void myadvice(JoinPoint jp, Object result)//it is advice (after returning advice)
        {
            System.out.println("additional concern");
            System.out.println("Method Signature: " + jp.getSignature());
            System.out.println("Result in advice: "+result);
            System.out.println("end of after returning advice...");
        }
}

