package com.sorb.testproject.service;

import com.sorb.testproject.model.Location;
import com.sorb.testproject.model.PersonId;
import org.json.simple.JSONObject;

public interface PersonIdService extends ExportParams<PersonId> {
    PersonId saveAndGetPersonId(JSONObject object);
}
