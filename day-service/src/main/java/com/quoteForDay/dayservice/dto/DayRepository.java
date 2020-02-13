package com.quoteForDay.dayservice.dto;

import com.quoteForDay.dayservice.model.Day;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DayRepository extends JpaRepository<Day, Long> {

}

