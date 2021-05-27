package com.sorb.testproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PersonService {

    @Autowired
    private RestTemplate restTemplate;


    @Value("${externalapi.url}")
    private String apiUrl;

    public void importUsersToDatabase(int count) {

        String result = restTemplate.getForObject(apiUrl, String.class);
        System.out.println(result);

    }

}
