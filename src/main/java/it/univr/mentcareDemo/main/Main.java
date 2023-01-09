package it.univr.mentcareDemo.main;

import it.univr.mentcareDemo.controller.ReportController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.time.LocalDate;

@SpringBootApplication(scanBasePackages = "it.univr.mentcareDemo.*")
@EnableJpaRepositories("it.univr.mentcareDemo")
@EntityScan("it/univr/mentcareDemo/model")
public class Main{

    public static void main(String[] args) {

        SpringApplication.run(Main.class,args);
    }
}