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

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    private final RestTemplate restTemplate;

    private final LocationService locationService;

    private final PersonIdService personIdService;

    private final PersonContactsService personContactsService;

    private final PersonPicturesService personPicturesService;

    private final PersonLoginService personLoginService;

    private final PersonInfoService personInfoService;

    private final TimezoneService timezoneService;

    @Value("${externalapi.url}")
    private String apiUrl;

    public PersonServiceImpl(RestTemplate restTemplate, LocationService locationService, PersonIdService personIdService, PersonContactsService personContactsService, PersonPicturesService personPicturesService, PersonLoginService personLoginService, PersonInfoRepository personInfoRepository, PersonInfoService personInfoService, TimezoneService timezoneService) {
        this.restTemplate = restTemplate;
        this.locationService = locationService;
        this.personIdService = personIdService;
        this.personContactsService = personContactsService;
        this.personPicturesService = personPicturesService;
        this.personLoginService = personLoginService;
        this.personInfoService = personInfoService;
        this.timezoneService = timezoneService;
    }

    @Override
    public void importUserToDatabase(int count) {
        String URL = apiUrl + "/api/?results=" + count;
        String result = restTemplate.getForObject(URL, String.class);
        JSONObject object;
        try {
            object = (JSONObject) new JSONParser().parse(result);
//            result = (String) object.get("result");
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

    @Override
    public List<String[]> createCSVDataList() {
        List<String[]> result = new ArrayList<>();
        result.add(getAllHeaders());
        for (PersonInfo pInfo: personInfoService.getAll())
        {
            result.add(getValues(pInfo));
        }
        return result;
    }

    private String[] getAllHeaders() {
        String[] headers = personInfoService.getHeaders();
        String[] b;
        b = locationService.getHeaders();
        headers = combine(headers, b);
        b = timezoneService.getHeaders();
        headers = combine(headers, b);
        b = personLoginService.getHeaders();
        headers = combine(headers, b);
        b = personIdService.getHeaders();
        headers = combine(headers, b);
        b = personContactsService.getHeaders();
        headers = combine(headers, b);
        b = personPicturesService.getHeaders();
        headers = combine(headers, b);
        return headers;

    }
    private String[] getValues(PersonInfo personInfo) {
        String[] headers = personInfoService.getValues(personInfo);
        String[] b;
        b = locationService.getValues(personInfo.getLocation());
        headers = combine(headers, b);
        b = timezoneService.getValues(personInfo.getLocation().getTimezone());
        headers = combine(headers, b);
        b = personLoginService.getValues(personInfo.getPersonLogin());
        headers = combine(headers, b);
        b = personIdService.getValues(personInfo.getPersonId());
        headers = combine(headers, b);
        b = personContactsService.getValues(personInfo.getPersonContacts());
        headers = combine(headers, b);
        b = personPicturesService.getValues(personInfo.getPersonPictures());
        headers = combine(headers, b);
        return headers;

    }

    public static String[] combine(String[] a, String[] b) {
        int length = a.length + b.length;
        String[] result = new String[length];
        System.arraycopy(a, 0, result, 0, a.length);
        System.arraycopy(b, 0, result, a.length, b.length);
        return result;
    }

}
