package com.pyro.diony;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class DionyApplication {

    public static void main(String[] args) {
        SpringApplication.run(DionyApplication.class, args);
    }

}
