package com.sorb.testproject.service;

import com.sorb.testproject.model.PersonId;
import org.json.simple.JSONObject;

public interface PersonIdService {
    PersonId saveAndGetPersonId(JSONObject object);
}
