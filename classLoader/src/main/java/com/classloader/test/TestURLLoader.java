package main.java.com.classloader.test;

import main.java.com.world.Person;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLClassLoader;

public class TestURLLoader {

    public static void main(String[] args) throws ClassNotFoundException, MalformedURLException, InstantiationException, IllegalAccessException {
        new LoaderFromDisk();
    }

}


class LoaderFromDisk {


    LoaderFromDisk() throws MalformedURLException, ClassNotFoundException, IllegalAccessException, InstantiationException {

        File file = new File("F:/git-worksapce/try-new-technologies/classLoader/src/com/world/");
        URI uri = file.toURI();
        URL url = uri.toURL();
        URLClassLoader urlClassLoader = new URLClassLoader(new URL[]{url});
        System.out.println("urlClassLoader的父加载器="+urlClassLoader.getParent());
        Class aclass = urlClassLoader.loadClass("main.java.com.world.Person");
        Person obj = (Person)aclass.newInstance();
        obj.setName("zhangsan");
        obj.setAge(12);
        System.out.println(obj.toString());

    }
}
