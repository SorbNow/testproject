package com.sorb.testproject.service;

import com.sorb.testproject.model.Location;
import com.sorb.testproject.repository.LocationRepository;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepository;
    private final TimezoneService timezoneService;

    public LocationServiceImpl(LocationRepository locationRepository, TimezoneService timezoneService) {
        this.locationRepository = locationRepository;
        this.timezoneService = timezoneService;
    }

    @Override
    public Location saveAndGetLocation(JSONObject object) {
        Map<String, String> street = getStreet((JSONObject) object.get("street"));
        Map<String, String> coordinates = getCoordinates((JSONObject) object.get("coordinates"));
        Location location = new Location();
        location.setCity((String) object.get("city"));
        location.setCountry((String) object.get("country"));

        location.setLatitude(coordinates.get("latitude"));
        location.setLongitude(coordinates.get("longitude"));

        location.setNumber(street.get("number"));
        location.setStreet(street.get("streetName"));

        location.setPostcode(object.get("postcode").toString());
        location.setState((String) object.get("state"));

        location.setTimezone(timezoneService.saveAndGetTimezone((JSONObject) object.get("timezone")));
        return locationRepository.save(location);
    }

    private Map<String, String> getStreet(JSONObject object) {
        Map<String, String> result = new HashMap<>();
        result.put("number", object.get("number").toString());
        result.put("streetName", (String) object.get("name"));

        return result;
    }

    private Map<String, String> getCoordinates(JSONObject object) {
        Map<String, String> result = new HashMap<>();
        result.put("latitude", object.get("latitude").toString());
        result.put("longitude", object.get("longitude").toString());

        return result;
    }

    @Override
    public String[] getHeaders() {
        return new String[]{"country", "state", "city", "street", "number", "postcode", "latitude", "longitude"};
    }

    @Override
    public String[] getValues(Location location) {
        return new String[]{location.getCountry(), location.getState(), location.getCity(),
                location.getStreet(), location.getNumber(), location.getPostcode(),
                location.getLatitude(), location.getLongitude()};
    }
}
