package com.sorb.testproject.service;

import com.sorb.testproject.model.Location;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PersonService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LocationService locationService;

    @Value("${externalapi.url}")
    private String apiUrl;

    public void importUserToDatabase(int count) {
        String URL = apiUrl + "/api/?results=" + count;
        System.out.println(URL);
        String result = restTemplate.getForObject(URL, String.class);
        System.out.println(result);
        JSONObject object = null;
        try {
            object = (JSONObject) new JSONParser().parse(result);
            result = (String) object.get("result");
            JSONArray array = (JSONArray) object.get("results");
            for (Object o : array) {
                JSONObject person = (JSONObject) o;
                String gender = (String) person.get("gender");
                JSONObject locationObject = (JSONObject) person.get("location");

                Location location = locationService.saveAndGetLocation(locationObject);

                System.out.println(location);
                System.out.println(gender);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

}
