package com.crelle.start;

import com.crelle.start.dto.PathPrefix;

/**
 * @ProjectName try-new-technologies
 * @ClassName Main
 * @Description 增量打包工具
 * @Author crelle
 * @Date 2020/5/30 17:59
 * @Version 1.0
 **/
public class Main {
    public static void main(String[] args) {
            new Entry();
    }
}

class  Entry{

    private String[] arges;

    public Entry(String[] arges) {
        this.arges = arges;
    }

    public Entry() {
        new PathPrefix();
    }
}
