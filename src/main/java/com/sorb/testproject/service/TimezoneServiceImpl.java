package com.sorb.testproject.service;

import com.sorb.testproject.model.Timezone;
import com.sorb.testproject.repository.TimezoneRepository;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TimezoneServiceImpl implements TimezoneService, ExportParams<Timezone> {
    private final TimezoneRepository timezoneRepository;

    public TimezoneServiceImpl(TimezoneRepository timezoneRepository) {
        this.timezoneRepository = timezoneRepository;
    }

    @Override
    public Timezone saveAndGetTimezone(JSONObject object) {
        Timezone timezone = new Timezone();
        timezone.setDescription((String)object.get("description"));
        timezone.setTimezoneOffset((String)object.get("offset"));
        return timezoneRepository.save(timezone);
    }

    @Override
    public String[] getHeaders() {
        return new String[]{"timezoneOffset", "desc"};
    }

    @Override
    public String[] getValues(Timezone timezone) {
        return new String[]{timezone.getTimezoneOffset(),timezone.getDescription()};
    }


}
