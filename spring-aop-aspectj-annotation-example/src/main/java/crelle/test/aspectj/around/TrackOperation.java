package crelle.test.aspectj.around;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
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
@Component(value = "aroundTrackOperation")
public class TrackOperation {
    @Pointcut("execution(* Operation.*(..))")
    public void abcPointcut() {
    }

    @Around("abcPointcut()")
    public Object myadvice(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("Additional Concern Before calling actual method");
        Object obj = pjp.proceed();
        System.out.println("Additional Concern After calling actual method");
        return obj;
    }
}