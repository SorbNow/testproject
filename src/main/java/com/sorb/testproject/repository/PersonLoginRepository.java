package com.sorb.testproject.repository;

import com.sorb.testproject.model.PersonLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonLoginRepository extends JpaRepository<PersonLogin, Integer> {
}
