package crelle.test.aspectj;

import crelle.test.aspectj.afterthrowing.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import javax.annotation.Resource;

@SpringBootApplication
public class SpringAopAspectjAnnotationExampleApplication implements CommandLineRunner {

    @Autowired
    private Operation operation;

    public static void main(String[] args) {
        SpringApplication.run(SpringAopAspectjAnnotationExampleApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
            //after and before
//        System.out.println("calling msg...");
//        operation.msg();
//        System.out.println("calling m...");
//        operation.m();
//        System.out.println("calling k...");
//        operation.k();

          //afterreturning
//        System.out.println("calling m...");
//        System.out.println(operation.m());
//        System.out.println("calling k...");
//        System.out.println(operation.k());

//        //around
//        operation.msg();
//        operation.display();

        //afterthrowing
        try{
            operation.validate(19);
        }catch(Exception e){
            System.out.println(e);
        }

         System.out.println("calling validate again...");

        try{
            operation.validate(11);
        }catch(Exception e){
            System.out.println(e);
        }

    }
}
