package com.sorb.testproject.service;

import org.springframework.stereotype.Service;

@Service
public class WelcomeService {
    private final PersonServiceImpl personServiceImpl;

    public WelcomeService(PersonServiceImpl personServiceImpl) {
        this.personServiceImpl = personServiceImpl;
    }


    public void launch(String[] args) {
        System.out.println("welcome to project. ");
        System.out.println();
        personServiceImpl.importUserToDatabase(2);
    }
}
