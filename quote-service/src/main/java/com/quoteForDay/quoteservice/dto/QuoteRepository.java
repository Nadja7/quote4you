package com.quoteForDay.quoteservice.dto;

import com.quoteForDay.quoteservice.model.Quote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuoteRepository extends JpaRepository<Quote, Long> {

    Quote findById(Integer id);

    List<Quote> findAll();

    List<Quote> findAllByDayId(Integer dayId);

}


