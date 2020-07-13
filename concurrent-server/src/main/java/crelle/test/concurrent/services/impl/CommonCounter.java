package crelle.test.concurrent.services.impl;

import crelle.test.concurrent.services.Counter;
import org.springframework.stereotype.Service;

@Service
public class CommonCounter implements Counter {

    private int c = 0;

    @Override
    public void increment() {
        c++;
    }

    @Override
    public void decrement() {
        c--;
    }

    @Override
    public int value() {
        return c;
    }
}
