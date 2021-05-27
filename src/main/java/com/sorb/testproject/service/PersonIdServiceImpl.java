package com.sorb.testproject.service;

import com.sorb.testproject.model.PersonId;
import com.sorb.testproject.repository.PersonIdRepository;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonIdServiceImpl implements PersonIdService {

    private final PersonIdRepository personIdRepository;

    public PersonIdServiceImpl(PersonIdRepository personIdRepository) {
        this.personIdRepository = personIdRepository;
    }

    @Override
    public PersonId saveAndGetPersonId(JSONObject object) {
        PersonId personId = new PersonId();
        personId.setName(object.get("name").toString());
        personId.setValue(object.get("value").toString());
        return personIdRepository.save(personId);
    }
}
