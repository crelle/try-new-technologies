package dynamic.proxy;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * MyInvocationHandler
 *
 * @author Scott Smith 2018-03-01 20:19
 */
public class DogInvocationHandler implements InvocationHandler {
    private Dog dog;

    public DogInvocationHandler(DogImpl dog) {
        this.dog = dog;
    }

    @Override
    public void invoke(Method method, Object[] args) {
        long start = System.currentTimeMillis();

        try {
            method.invoke(dog, null);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("time = " + (end - start));
    }
}
