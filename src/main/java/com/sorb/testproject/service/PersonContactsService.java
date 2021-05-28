package com.sorb.testproject.service;

import com.sorb.testproject.model.Location;
import com.sorb.testproject.model.PersonContacts;
import org.json.simple.JSONObject;

public interface PersonContactsService extends ExportParams<PersonContacts>{
    PersonContacts saveAndGetPersonContacts(JSONObject object);
}
