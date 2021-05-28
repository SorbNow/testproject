package com.sorb.testproject.service;

import com.sorb.testproject.model.PersonId;
import com.sorb.testproject.repository.PersonIdRepository;
import org.json.simple.JSONObject;
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
        personId.setName((String)object.get("name"));
        personId.setValue((String) object.get("value"));
        return personIdRepository.save(personId);
    }

    @Override
    public String[] getHeaders() {
        return new String[]{"id name", "value"};
    }

    @Override
    public String[] getValues(PersonId personId) {
        return new String[]{personId.getName(),personId.getValue()};
    }
}
