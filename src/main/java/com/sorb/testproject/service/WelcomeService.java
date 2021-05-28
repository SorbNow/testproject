package com.sorb.testproject.service;

import com.opencsv.CSVWriter;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;

@Service
public class WelcomeService {
    private final PersonServiceImpl personServiceImpl;

    public WelcomeService(PersonServiceImpl personServiceImpl) {
        this.personServiceImpl = personServiceImpl;
    }


    public void launch(String[] args) {
        System.out.println("welcome to project. ");
        System.out.println();
        personServiceImpl.importUserToDatabase(5);

        try (CSVWriter writer = new CSVWriter(new FileWriter("test.csv"))) {
            writer.writeAll(personServiceImpl.createCSVDataList());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
