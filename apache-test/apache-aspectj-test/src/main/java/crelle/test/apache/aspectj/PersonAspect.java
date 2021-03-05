package crelle.test.apache.aspectj;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author:crelle
 * @className:BuildPerson
 * @version:1.0.0
 * @date:2021/3/5
 * @description:XX
 **/
@Configuration
@Aspect
public class PersonAspect {

    private static final  String ASPECT_POINT = "execution(* crelle.test.apache.aspectj.PersonService.*(..))";

    @Pointcut(ASPECT_POINT)
    public void pointCutMethod(){
        System.out.println("--------------->开始拦截方法！");
    }

    @AfterReturning(value = "pointCutMethod()",returning = "obj")
    public void doAfterReturn(Object obj){
        try{
            if(obj instanceof Person){
                Person person = (Person) obj;
                Class cls = person.getClass();
                Field[] fields = cls.getDeclaredFields();
                String prefix = null;
                for (Field f: fields) {
                 CityAnno cityAnno = f.getDeclaredAnnotation(CityAnno.class);
                 if(null!=cityAnno){
                     prefix = cityAnno.prefix();
                     break;
                 }
                }
              Field city =  person.getClass().getDeclaredField("city");
                city.setAccessible(true);
                city.set(person,prefix+city.getName());
            }
        }catch (Exception e){

        }
    }
}
