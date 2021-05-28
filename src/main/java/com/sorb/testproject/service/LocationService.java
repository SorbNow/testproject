package com.sorb.testproject.service;

import com.sorb.testproject.model.Location;
import org.json.simple.JSONObject;

public interface LocationService extends ExportParams<Location> {
    Location saveAndGetLocation(JSONObject object);
}
