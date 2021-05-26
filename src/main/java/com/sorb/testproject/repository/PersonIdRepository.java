package com.sorb.testproject.repository;

import com.sorb.testproject.model.PersonId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonIdRepository extends JpaRepository<PersonId, Integer> {
}
