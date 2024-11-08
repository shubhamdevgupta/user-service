package org.example.userservicenew;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EurekaClientAutoConfiguration;

@SpringBootApplication

public class UserServiceNewApplication {

    public static void main(String[] args) {

        SpringApplication.run(UserServiceNewApplication.class, args);
    }

}
