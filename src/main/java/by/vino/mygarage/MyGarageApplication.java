package by.vino.mygarage;

import by.vino.mygarage.config.JpaConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyGarageApplication {

    public static void main(String[] args) {
        SpringApplication.run(new Class<?>[] {MyGarageApplication.class, JpaConfig.class}, args);
    }
}