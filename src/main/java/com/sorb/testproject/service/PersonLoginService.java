package com.sorb.testproject.service;

import com.sorb.testproject.model.Location;
import com.sorb.testproject.model.PersonLogin;
import org.json.simple.JSONObject;

public interface PersonLoginService extends ExportParams<PersonLogin>{
    PersonLogin saveAndGetPersonLogin(JSONObject object);
}
