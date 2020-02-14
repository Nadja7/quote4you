package com.quoteForDay.quoteservice.controller;

import com.quoteForDay.quoteservice.model.Quote;
import com.quoteForDay.quoteservice.service.QuoteServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class QuoteController {


    private final QuoteServiceImpl quoteServiceImpl;

    public QuoteController(QuoteServiceImpl quoteServiceImpl) {
        this.quoteServiceImpl = quoteServiceImpl;
    }

    @GetMapping(value = "/")
    public List<Quote> getAllQuotes() {
        return quoteServiceImpl.findAllQuotes();
    }

    @GetMapping(value = "/{id}")
    public Quote getQuoteById(@PathVariable("id") Integer id) {
        return quoteServiceImpl.findQuoteById(id);
    }


}
