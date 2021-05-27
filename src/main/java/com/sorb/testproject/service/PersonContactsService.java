package com.sorb.testproject.service;

import com.sorb.testproject.model.PersonContacts;
import org.json.simple.JSONObject;

public interface PersonContactsService {
    PersonContacts saveAndGetPersonContacts(JSONObject object);
}
