package com.sorb.testproject.service;

import com.sorb.testproject.model.*;
import org.json.simple.JSONObject;

import java.util.List;

public interface PersonInfoService extends ExportParams<PersonInfo> {
    PersonInfo saveAndGetPersonInfo(JSONObject object,
                                    PersonId personId,
                                    Location location,
                                    PersonContacts personContacts,
                                    PersonLogin personLogin,
                                    PersonPictures personPictures);

    List<PersonInfo> getAll();
}
