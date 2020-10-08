package crelle.test.concurrent.services.impl;


import crelle.test.concurrent.services.Maper;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;

@Service
public class ConcurrentHashMapMaper implements Maper {

    ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();

    @Override
    public void push() {

    }

    @Override
    public void modify() {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public String isSuccess() {
        return null;
    }
}
