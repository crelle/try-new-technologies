package com.crelle.start.common;

import com.crelle.start.dto.PathPrefix;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @ProjectName try-new-technologies
 * @ClassName Utils
 * @Description 抽象工具类
 * @Author crelle
 * @Date 2020/5/30 18:41
 * @Version 1.0
 **/
public abstract class Utils {


    public static Properties buildProperties(){
        Properties properties = new Properties();
        InputStream inputStream = PathPrefix.class.getClassLoader().getResourceAsStream("com/crelle/start/config/config.properties");
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
            return properties;
    }


}
