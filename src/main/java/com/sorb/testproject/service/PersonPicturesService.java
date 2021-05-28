package com.sorb.testproject.service;

import com.sorb.testproject.model.Location;
import com.sorb.testproject.model.PersonPictures;
import org.json.simple.JSONObject;

public interface PersonPicturesService extends ExportParams<PersonPictures> {
    PersonPictures saveAndGetPersonPictures(JSONObject object);
}
