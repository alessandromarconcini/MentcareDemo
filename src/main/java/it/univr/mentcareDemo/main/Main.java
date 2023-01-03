package it.univr.mentcareDemo.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "it.univr.mentcareDemo.*")
@EnableJpaRepositories("it.univr.mentcareDemo")
@EntityScan("it/univr/mentcareDemo/model")
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);
    }
}