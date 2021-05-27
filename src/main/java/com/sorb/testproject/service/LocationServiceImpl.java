package com.sorb.testproject.service;

import com.sorb.testproject.model.Location;
import com.sorb.testproject.model.Timezone;
import com.sorb.testproject.repository.LocationRepository;
import com.sorb.testproject.repository.TimezoneRepository;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepository;

    private final TimezoneRepository timezoneRepository;

    public LocationServiceImpl(LocationRepository locationRepository, TimezoneRepository timezoneRepository) {
        this.locationRepository = locationRepository;
        this.timezoneRepository = timezoneRepository;
    }

    @Override
    public Location saveAndGetLocation(JSONObject object) {
        Map<String, String> street = getStreet((JSONObject) object.get("street"));
        Map<String, String> coordinates = getCoordinates((JSONObject) object.get("coordinates"));
        Location location = new Location();
        location.setCity((String)object.get("city"));
        location.setCountry((String)object.get("country"));

        location.setLatitude(coordinates.get("latitude"));
        location.setLongitude(coordinates.get("longitude"));

        location.setNumber(street.get("number"));
        location.setStreet(street.get("streetName"));

        location.setPostcode(object.get("postcode").toString());
        location.setState((String)object.get("state"));

        location.setTimezone(saveAndGetTimezone((JSONObject) object.get("timezone")));
        return locationRepository.save(location);
    }

    @Override
    public Timezone saveAndGetTimezone(JSONObject object) {
        Timezone timezone = new Timezone();
        timezone.setDescription((String)object.get("description"));
        timezone.setTimezoneOffset((String)object.get("offset"));
        return timezoneRepository.save(timezone);
    }

    private Map<String,String> getStreet(JSONObject object) {
        Map<String,String> result = new HashMap<>();
        result.put("number", object.get("number").toString());
        result.put("streetName", (String) object.get("name"));

        return result;
    }
    private Map<String,String> getCoordinates(JSONObject object) {
        Map<String,String> result = new HashMap<>();
        result.put("latitude", object.get("latitude").toString());
        result.put("longitude", object.get("longitude").toString());

        return result;
    }
}
