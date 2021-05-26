package com.sorb.testproject.repository;

import com.sorb.testproject.model.PersonContacts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonContactsRepository extends JpaRepository<PersonContacts, Integer> {
}
