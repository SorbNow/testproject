package com.sorb.testproject.service;

import org.springframework.stereotype.Service;

@Service
public class WelcomeService {
    private final PersonService personService;

    public WelcomeService(PersonService personService) {
        this.personService = personService;
    }


    public void launch(String[] args) {
        System.out.println("welcome to project. ");
        System.out.println();
        personService.importUsersToDatabase(1);
    }
}
