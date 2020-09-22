package crelle.test.aspectj.after;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
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
@Component(value = "afterTrackOperation")
public class TrackOperation {

    @Pointcut("execution(* Operation.*(..))")
    public void k() {
    }

    @After("k()")//applying pointcut on after advice
    public void myadvice(JoinPoint jp)//it is advice (after advice)
    {
        System.out.println("additional concern");
        //System.out.println("Method Signature: "  + jp.getSignature());
    }
}