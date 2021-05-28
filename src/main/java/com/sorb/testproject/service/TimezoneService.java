package com.sorb.testproject.service;

import com.sorb.testproject.model.Location;
import com.sorb.testproject.model.Timezone;
import org.json.simple.JSONObject;

public interface TimezoneService extends ExportParams<Timezone> {
    Timezone saveAndGetTimezone(JSONObject object);
}
