package dynamic.proxy;

import org.junit.Test;

/**
 * @author:crelle
 * @className:TestBird
 * @version:1.0.0
 * @date:2021/5/12
 * @description:XX
 **/
public class ProxyTest {

    @Test
    public void birdProxy() throws Exception {
        Object birdProxy = Proxy.newProxyInstance("BirdProxy", Bird.class, new BirdInvocationHandler(new BirdImpl()));
        System.out.println(birdProxy.getClass().getName());
        ((Bird)birdProxy).fly();
        ((Bird) birdProxy).eat();
        ((Bird) birdProxy).sing();

    }

    @Test
    public void dogProxy() throws Exception {
        Object dogProxy = Proxy.newProxyInstance("DogProxy",Dog.class, new DogInvocationHandler(new DogImpl()));
        System.out.println(dogProxy.getClass().getName());
        ((Dog) dogProxy).eat();
        ((Dog) dogProxy).sleep();
        ((Dog) dogProxy).walk();

    }


}
