package com.sorb.testproject.service;

import com.sorb.testproject.model.*;
import com.sorb.testproject.repository.PersonInfoRepository;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;

@Service
public class PersonInfoServiceImpl implements PersonInfoService {

    @Autowired
    private PersonInfoRepository personInfoRepository;

    @Override
    public PersonInfo saveAndGetPersonInfo(JSONObject object, PersonId personId, Location location,
                                           PersonContacts personContacts, PersonLogin personLogin,
                                           PersonPictures personPictures) {

        PersonInfo personInfo = new PersonInfo();
        personInfo.setPersonId(personId);
        personInfo.setLocation(location);
        personInfo.setPersonContacts(personContacts);
        personInfo.setPersonLogin(personLogin);
        personInfo.setPersonPictures(personPictures);
        personInfo.setGender(object.get("gender").toString());
        personInfo.setEmail(object.get("email").toString());
        personInfo.setNationality(object.get("nat").toString());

        Map<String, String> personName = getName((JSONObject) object.get("name"));

        personInfo.setTitle(personName.get("title"));
        personInfo.setFirstName(personName.get("firstName"));
        personInfo.setLastName(personName.get("lastName"));

        personInfo.setDateOfBirth(getDate((JSONObject) object.get("dob")));
        personInfo.setRegistrationDate(getDate((JSONObject) object.get("registered")));

        System.out.println("info:");
        System.out.println(personInfo);

        return personInfoRepository.save(personInfo);
    }

    private Map<String, String> getName(JSONObject object) {
        Map<String, String> result = new HashMap<>();
        result.put("title", object.get("title").toString());
        result.put("firstName", (String) object.get("first"));
        result.put("lastName", (String) object.get("last"));
        return result;
    }

    private LocalDateTime getDate(JSONObject object) {

        ZoneId z = ZoneId.systemDefault() ;
        LocalDateTime result = LocalDateTime.ofInstant(Instant.parse(object.get("date").toString()),z);
        return result;
    }
}
