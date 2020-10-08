package crelle.test.springframework;

import crelle.test.springframework.beans.factory.annotation.annotationtypes.resourcevsinjectvsautowired.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.Serializable;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;
    @Autowired
    private RedisTemplate<Serializable, Serializable> redisTemplate;


    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

//        redisConnectionFactory.getClusterConnection();
        redisTemplate.opsForValue();

    }
}
