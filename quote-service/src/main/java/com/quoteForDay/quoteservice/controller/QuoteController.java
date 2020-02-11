package com.quoteForDay.quoteservice.controller;

import com.quoteForDay.quoteservice.dto.QuoteRepository;
import com.quoteForDay.quoteservice.model.Quote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

@RestController
public class QuoteController {

    @Autowired
    QuoteRepository quoteRepository;

    @RequestMapping(value = "/quote/{id}")
    public Optional<Quote> findQuotesId(@PathVariable("id") Long id) {
       return quoteRepository.findById(id);
    }

    @RequestMapping(value = "/")
    public List<Quote> findAllQuotes() {
        return quoteRepository.findAll();
    }

    @RequestMapping(value = "/quoteByDayId/{day_id}")
    public Optional<Quote> findQuotesByDayId(@PathVariable("day_id") int dayId)  {
        return quoteRepository.findAllByDayId(dayId);
    }
}
