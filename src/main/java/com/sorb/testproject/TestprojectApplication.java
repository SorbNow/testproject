package com.sorb.testproject;

import com.sorb.testproject.service.WelcomeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestprojectApplication implements CommandLineRunner {

    private final WelcomeService welcomeService;

    public TestprojectApplication(WelcomeService welcomeService) {
        this.welcomeService = welcomeService;
    }

    public static void main(String[] args) {
        SpringApplication.run(TestprojectApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        welcomeService.launch(args);
    }
}
