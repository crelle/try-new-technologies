package crelle.test.concurrent.services.impl;

import crelle.test.concurrent.services.Maper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

@Service
public class HashMapMaper implements Maper {

    ArrayList arrayList = new ArrayList();
    HashMap hashMap = new HashMap();


    @Override
    public void push() {
        hashMap.put("key1","aaa");
        hashMap.put("key2","bbb");
        hashMap.put("key3","ccc");
    }

    /**
     * 应该是最后一个请求的值
     */
    @Override
    public void modify() {
        System.out.println(Thread.currentThread().getName());
        String value = UUID.randomUUID().toString();
        arrayList.add(value);
        System.out.println(value);
        hashMap.put("key1",value);
    }

    @Override
    public int size() {
        return hashMap.size();
    }

    @Override
    public String isSuccess() {
        System.out.println("arraylist last value:"+arrayList.get(arrayList.size()-1));
        if(hashMap.get("key1").equals(arrayList.get(arrayList.size()-1))){
            return "成功！";
        }else {
            return "失败";
        }
    }
}
