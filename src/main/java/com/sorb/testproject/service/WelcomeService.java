package com.sorb.testproject.service;

import com.opencsv.CSVWriter;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

@Service
public class WelcomeService {
    private final PersonServiceImpl personServiceImpl;

    private final ApplicationContext context;

    public WelcomeService(PersonServiceImpl personServiceImpl, ApplicationContext context) {
        this.personServiceImpl = personServiceImpl;
        this.context = context;
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
            switch (answer) {
                case 1: {
                    do {
                        System.out.println("Input count");
                        sAnswer = scanner.nextLine();
                    } while (!checkCount(sAnswer));

                    importPersons(Integer.parseInt(sAnswer));
                    break;
                }

                case 2: {
                    do {
                        System.out.println("Input count");
                        sAnswer = scanner.nextLine();
                    } while (!checkCount(sAnswer));
                    exportPersons(Integer.parseInt(sAnswer));
                    break;
                }
            }

        } while (answer != 0);
        scanner.close();
        SpringApplication.exit(context);
    }

    private void importPersons(int answer) {
        final int MAX_COUNT = 5000;
        //int answer = getCount();
        for (int count = answer / MAX_COUNT; count > 0; count--) {
            personServiceImpl.importUserToDatabase(MAX_COUNT);
        }
        personServiceImpl.importUserToDatabase(answer % MAX_COUNT);
        System.out.println("Imported " + answer + " values. ");
        System.out.println("if the value is different, then you entered a value greater than " + Integer.MAX_VALUE);
        System.out.println();

    }

    private void exportPersons(int count) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd_MM_yyyy_HH_mm_ss");
        try (CSVWriter writer = new CSVWriter(new FileWriter("test_" +
                LocalDateTime.now().format(formatter) + ".csv"))) {
            writer.writeAll(personServiceImpl.createCSVDataList(count));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean checkCount(String sAnswer) {
        int answer = -2;
        do {
            try {
                answer = Integer.parseInt(sAnswer.trim());
                if (answer < 0) {
                    System.out.println("Count can't be negative");
                    return false;
                }
            } catch (NumberFormatException e) {
                System.out.println("Wrong selection. Please, use numbers");
                return false;
            }

        } while (!(answer > 0));
        return true;
    }
}
