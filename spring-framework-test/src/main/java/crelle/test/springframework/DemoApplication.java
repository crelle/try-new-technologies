package crelle.test.springframework;

import crelle.test.springframework.beans.factory.annotation.annotationtypes.test1.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    @Autowired
    private AnimalKeeper5_1 animalKeeper;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println(animalKeeper.getTiger().type());

    }
}
