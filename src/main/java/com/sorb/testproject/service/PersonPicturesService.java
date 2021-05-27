package com.sorb.testproject.service;

import com.sorb.testproject.model.PersonPictures;
import org.json.simple.JSONObject;

public interface PersonPicturesService {
    PersonPictures saveAndGetPersonPictures(JSONObject object);
}
