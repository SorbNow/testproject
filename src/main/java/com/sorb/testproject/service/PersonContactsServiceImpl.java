package com.sorb.testproject.service;

import com.sorb.testproject.model.PersonContacts;
import com.sorb.testproject.repository.PersonContactsRepository;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonContactsServiceImpl implements PersonContactsService {

    private final PersonContactsRepository personContactsRepository;

    public PersonContactsServiceImpl(PersonContactsRepository personContactsRepository) {
        this.personContactsRepository = personContactsRepository;
    }

    @Override
    public PersonContacts saveAndGetPersonContacts(JSONObject object) {
        PersonContacts personContacts = new PersonContacts();
        personContacts.setCell(object.get("cell").toString());
        personContacts.setPhone(object.get("phone").toString());
        return personContactsRepository.save(personContacts);
    }
}
