package com.sorb.testproject.service;

import com.sorb.testproject.model.Location;
import org.json.simple.JSONObject;

public interface LocationService {
    Location saveAndGetLocation(JSONObject object);
}
