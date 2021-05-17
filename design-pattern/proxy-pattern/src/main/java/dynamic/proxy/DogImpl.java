package dynamic.proxy;

import java.util.Random;

/**
 * @author:crelle
 * @className:DogImpl
 * @version:1.0.0
 * @date:2021/5/17
 * @description:XX
 **/
public class DogImpl  implements Dog{
    @Override
    public void walk() {
        System.out.println("Dog is walking...");
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eat() {
        System.out.println("Dog is eating...");
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sleep() {
        System.out.println("Dog is Sleeping...");
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
