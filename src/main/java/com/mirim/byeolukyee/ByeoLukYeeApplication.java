package com.mirim.byeolukyee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ByeoLukYeeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ByeoLukYeeApplication.class, args);
    }

}
