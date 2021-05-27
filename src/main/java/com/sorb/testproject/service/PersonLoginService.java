package com.sorb.testproject.service;

import com.sorb.testproject.model.PersonLogin;
import org.json.simple.JSONObject;

public interface PersonLoginService {
    PersonLogin saveAndGetPersonLogin(JSONObject object);
}
