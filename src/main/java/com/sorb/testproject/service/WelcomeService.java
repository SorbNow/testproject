package com.sorb.testproject.service;

import com.opencsv.CSVWriter;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

@Service
public class WelcomeService {
    private final PersonServiceImpl personServiceImpl;

    public WelcomeService(PersonServiceImpl personServiceImpl) {
        this.personServiceImpl = personServiceImpl;
    }


    public void launch(String[] args) {

        System.out.println("Welcome to project.");
        System.out.println("Database is empty when project starts");
        System.out.println("because we use H2 in memory DB.");
        System.out.println();

        Scanner scanner = new Scanner(System.in);
        int answer = -2;
        do {
            System.out.println("Input number of option:");
            System.out.println("1. Import to DB from random user API");
            System.out.println("2. Export from DB to .csv file");
            System.out.println("Type 0 for exit");
            String sAnswer = scanner.nextLine();
            try {
                answer = Integer.parseInt(sAnswer.trim());
            } catch (NumberFormatException e) {
                System.out.println("Wrong selection");
            }
            switch (answer){
                case 1: importPersons();
                case 2: exportPersons();
            }

        } while (answer != 0);
        scanner.close();


        try (CSVWriter writer = new CSVWriter(new FileWriter("test.csv"))) {
            writer.writeAll(personServiceImpl.createCSVDataList());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void importPersons(){
        Scanner scanner = new Scanner(System.in);
        int answer = -2;
        do {
            System.out.println("Input count");
            String sAnswer = scanner.nextLine();
            try {
                answer = Integer.parseInt(sAnswer.trim());
                if (answer < 0){
                    System.out.println("Count can't be negative");
                }
            }catch (NumberFormatException e){
                System.out.println("Wrong selection");
            }

        }while (answer == -2);
        //TODO if answer>5000
        personServiceImpl.importUserToDatabase(answer);
        System.out.println("Imported " + answer + " values. ");
        System.out.println("if the value is different, then you entered a value greater than" + Integer.MAX_VALUE);

    }
    private void exportPersons(){
        //TODO export
    }
}
