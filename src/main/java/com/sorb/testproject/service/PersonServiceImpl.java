package com.sorb.testproject.service;

import com.sorb.testproject.model.*;
import com.sorb.testproject.repository.PersonInfoRepository;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PersonServiceImpl implements PersonService {

    private final RestTemplate restTemplate;

    private final LocationService locationService;

    private final PersonIdService personIdService;

    private final PersonContactsService personContactsService;

    private final PersonPicturesService personPicturesService;

    private final PersonLoginService personLoginService;

    private final PersonInfoService personInfoService;

    @Value("${externalapi.url}")
    private String apiUrl;

    public PersonServiceImpl(RestTemplate restTemplate, LocationService locationService, PersonIdService personIdService, PersonContactsService personContactsService, PersonPicturesService personPicturesService, PersonLoginService personLoginService, PersonInfoRepository personInfoRepository, PersonInfoService personInfoService) {
        this.restTemplate = restTemplate;
        this.locationService = locationService;
        this.personIdService = personIdService;
        this.personContactsService = personContactsService;
        this.personPicturesService = personPicturesService;
        this.personLoginService = personLoginService;
        this.personInfoService = personInfoService;
    }

    @Override
    public void importUserToDatabase(int count) {
        String URL = apiUrl + "/api/?results=" + count;
        String result = restTemplate.getForObject(URL, String.class);
        JSONObject object = null;
        try {
            object = (JSONObject) new JSONParser().parse(result);
            result = (String) object.get("result");
            JSONArray array = (JSONArray) object.get("results");
            for (Object o : array) {
                JSONObject person = (JSONObject) o;

                JSONObject locationObject = (JSONObject) person.get("location");
                Location location = locationService.saveAndGetLocation(locationObject);

                JSONObject personIdObject = (JSONObject) person.get("id");
                PersonId personId = personIdService.saveAndGetPersonId(personIdObject);

                PersonContacts personContacts = personContactsService.saveAndGetPersonContacts(person);

                JSONObject personPicturesObject = (JSONObject) person.get("picture");
                PersonPictures personPictures = personPicturesService.saveAndGetPersonPictures(personPicturesObject);

                JSONObject personLoginObject = (JSONObject) person.get("login");
                PersonLogin personLogin = personLoginService.saveAndGetPersonLogin(personLoginObject);

                PersonInfo personInfo = personInfoService.saveAndGetPersonInfo(person, personId, location,
                        personContacts, personLogin, personPictures);

                System.out.println(personInfo);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

}
