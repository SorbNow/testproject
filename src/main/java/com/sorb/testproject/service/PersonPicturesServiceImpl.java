package com.sorb.testproject.service;

import com.sorb.testproject.model.PersonPictures;
import com.sorb.testproject.repository.PersonPicturesRepository;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class PersonPicturesServiceImpl implements PersonPicturesService, ExportParams<PersonPictures> {

    private final PersonPicturesRepository personPicturesRepository;

    public PersonPicturesServiceImpl(PersonPicturesRepository personPicturesRepository) {
        this.personPicturesRepository = personPicturesRepository;
    }

    @Override
    public PersonPictures saveAndGetPersonPictures(JSONObject object) {
        PersonPictures personPictures = new PersonPictures();
        personPictures.setLargePic(object.get("large").toString());
        personPictures.setMediumPic(object.get("medium").toString());
        personPictures.setThumbnail(object.get("thumbnail").toString());
        return personPicturesRepository.save(personPictures);
    }

    @Override
    public String[] getHeaders() {
        return new String[]{"largePic", "mediumPic", "thumbnail"};
    }

    @Override
    public String[] getValues(PersonPictures personPictures) {
        return new String[]{personPictures.getLargePic(), personPictures.getMediumPic(), personPictures.getThumbnail()};
    }
}
