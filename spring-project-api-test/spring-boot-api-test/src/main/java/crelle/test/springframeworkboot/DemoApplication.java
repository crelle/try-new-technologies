package crelle.test.springframeworkboot;

import crelle.test.springframeworkboot.context.properties.configurationpropertiestest.SampleProperty;
import crelle.test.springframeworkboot.context.properties.configurationpropertiestest.SamplePropertyLoadingTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    @Autowired
    private SamplePropertyLoadingTest samplePropertyLoadingTest;


    @Autowired
    private SampleProperty sampleProperty;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(sampleProperty.getStringProp1());

        System.out.println("stringProp1 = " + sampleProperty.getStringProp1());
        System.out.println("stringProp2=" + sampleProperty.getStringProp2());
        System.out.println("listProp=" + sampleProperty.getListProp());
        System.out.println("mapProp=" + sampleProperty.getMapProp());
    }
}
