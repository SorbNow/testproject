package com.sorb.testproject.service;

import java.util.List;

public interface PersonService {
    void importUserToDatabase(int count);

    List<String[]> createCSVDataList(int count);
}
