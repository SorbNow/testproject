package com.sorb.testproject.service;

import com.sorb.testproject.model.*;
import com.sorb.testproject.repository.PersonInfoRepository;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PersonInfoServiceImpl implements PersonInfoService {

    private final PersonInfoRepository personInfoRepository;

    public PersonInfoServiceImpl(PersonInfoRepository personInfoRepository) {
        this.personInfoRepository = personInfoRepository;
    }

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

        return personInfoRepository.save(personInfo);
    }

    @Override
    public List<PersonInfo> getAll() {
        return personInfoRepository.findAll();
    }

    private Map<String, String> getName(JSONObject object) {
        Map<String, String> result = new HashMap<>();
        result.put("title", object.get("title").toString());
        result.put("firstName", (String) object.get("first"));
        result.put("lastName", (String) object.get("last"));
        return result;
    }

    private LocalDateTime getDate(JSONObject object) {

        ZoneId z = ZoneId.systemDefault();
        LocalDateTime result = LocalDateTime.ofInstant(Instant.parse(object.get("date").toString()), z);
        return result;
    }

    @Override
    public String[] getHeaders() {
        return new String[]{"id", "gender", "title", "first name", "lastName", "email", "dob",
                "age", "registration date", "years registered", "nationality"};
    }

    @Override
    public String[] getValues(PersonInfo personInfo) {
        return new String[]{String.valueOf(personInfo.getId()), personInfo.getGender(), personInfo.getTitle(),
                personInfo.getFirstName(), personInfo.getLastName(), personInfo.getEmail(),
                personInfo.getDateOfBirth().toString(), String.valueOf(personInfo.getAge()),
                personInfo.getRegistrationDate().toString(), String.valueOf(personInfo.getRegisteredYears()),
                personInfo.getNationality()};
    }
}
