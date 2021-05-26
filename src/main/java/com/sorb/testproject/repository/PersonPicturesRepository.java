package com.sorb.testproject.repository;

import com.sorb.testproject.model.PersonPictures;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonPicturesRepository extends JpaRepository<PersonPictures, Integer> {
}
