package crelle.test.concurrent.services.impl;

import crelle.test.concurrent.services.Counter;
import org.springframework.stereotype.Service;

@Service
public class SynchronizedCounter implements Counter {

    private int c = 0;

    @Override
    public synchronized  void increment() {
        c++;
    }

    @Override
    public synchronized  void decrement() {
        c--;
    }

    @Override
    public int value() {
        return c;
    }
}
