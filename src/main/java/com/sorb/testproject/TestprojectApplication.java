package com.sorb.testproject;

import com.sorb.testproject.service.WelcomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class TestprojectApplication implements CommandLineRunner{

    @Autowired
    private WelcomeService welcomeService;

    public static void main(String[] args) {
        SpringApplication.run(TestprojectApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        welcomeService.launch(args);
    }
}
