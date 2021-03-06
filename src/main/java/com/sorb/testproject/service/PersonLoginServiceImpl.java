package com.sorb.testproject.service;

import com.sorb.testproject.model.PersonLogin;
import com.sorb.testproject.repository.PersonLoginRepository;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class PersonLoginServiceImpl implements PersonLoginService {

    private final PersonLoginRepository personLoginRepository;

    public PersonLoginServiceImpl(PersonLoginRepository personLoginRepository) {
        this.personLoginRepository = personLoginRepository;
    }

    @Override
    public PersonLogin saveAndGetPersonLogin(JSONObject object) {
        PersonLogin personLogin = new PersonLogin();
        personLogin.setUuid(object.get("uuid").toString());
        personLogin.setUserName(object.get("username").toString());
        personLogin.setPassword(object.get("password").toString());
        personLogin.setSalt(object.get("salt").toString());
        personLogin.setMd5(object.get("md5").toString());
        personLogin.setSha1(object.get("sha1").toString());
        personLogin.setSha256(object.get("sha256").toString());
        return personLoginRepository.save(personLogin);
    }

    @Override
    public String[] getHeaders() {
        return new String[]{"uuid", "username", "password", "salt", "md5", "sha1", "sha256"};
    }

    @Override
    public String[] getValues(PersonLogin personLogin) {
        return new String[]{personLogin.getUuid(), personLogin.getUserName(), personLogin.getPassword(),
                personLogin.getSalt(), personLogin.getMd5(), personLogin.getSha1(), personLogin.getSha256()};
    }
}
