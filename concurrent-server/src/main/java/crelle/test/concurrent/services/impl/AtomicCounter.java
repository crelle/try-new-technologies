package crelle.test.concurrent.services.impl;

import crelle.test.concurrent.services.Counter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

@Service
@Scope(value = "singleton")
public class AtomicCounter implements Counter {

    private AtomicInteger c = new AtomicInteger(0);

    @Override
    public void increment() {
        c.incrementAndGet();
        System.out.println(value());
    }

    @Override
    public void decrement() {
        c.decrementAndGet();
    }

    @Override
    public int value() {
        return c.get();
    }
}
