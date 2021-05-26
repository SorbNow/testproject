package com.sorb.testproject.repository;

import com.sorb.testproject.model.Timezone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimezoneRepository extends JpaRepository<Timezone, Integer> {
    boolean existsByDescriptionAndTimezoneOffset(String description, String timezoneOffset);
}
