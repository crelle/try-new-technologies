package crelle.test.aspectj.before;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
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
@Component(value = "beforeTrackOperation")
public class TrackOperation {

    /**
     *@author:crelle
     *@date:2020/9/21
     *@title:k
     *@description:pointcut name
     *@params:[]
     *@return:void
     *@throw:
     */
    @Pointcut("execution(* crelle.test.aspectj.before.Operation.*(..))")
    public void k(){};

    /**
     *@author:crelle
     *@date:2020/9/21
     *@title:myadvice
     *@description: applying pointcut on before advice
     *@params:[jp]
     *@return:void
     *@throw:
     */
    @Before("k()")
    public void myadvice(JoinPoint jp){
        System.out.println("additional concern");
        System.out.println("Method Signature:"+jp.getSignature());
    }
}
