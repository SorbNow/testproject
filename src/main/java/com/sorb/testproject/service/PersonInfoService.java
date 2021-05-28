package com.sorb.testproject.service;

import com.sorb.testproject.model.*;
import org.json.simple.JSONObject;

public interface PersonInfoService {
    PersonInfo saveAndGetPersonInfo(JSONObject object,
                                    PersonId personId,
                                    Location location,
                                    PersonContacts personContacts,
                                    PersonLogin personLogin,
                                    PersonPictures personPictures);
}
