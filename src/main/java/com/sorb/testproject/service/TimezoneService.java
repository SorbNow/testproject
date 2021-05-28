package com.sorb.testproject.service;

import com.sorb.testproject.model.Timezone;
import org.json.simple.JSONObject;

public interface TimezoneService {
    Timezone saveAndGetTimezone(JSONObject object);
}
