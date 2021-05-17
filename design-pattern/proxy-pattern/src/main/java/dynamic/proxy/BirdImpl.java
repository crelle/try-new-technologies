package dynamic.proxy;

import java.util.Random;

/**
 * Bird
 *
 * @author Scott Smith 2018-02-28 15:42
 */
public class BirdImpl implements Bird {

    @Override
    public void fly() {
        System.out.println("Bird is flying...");
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    @Override
    public void eat() {

        System.out.println("Bird is eating...");
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sing() {
        System.out.println("Bird is singing...");
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
