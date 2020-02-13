package com.quoteForDay.quoteservice.controller;

import com.quoteForDay.quoteservice.model.Quote;
import com.quoteForDay.quoteservice.service.QuoteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class QuoteController {


    private final QuoteService quoteService;

    public QuoteController(QuoteService quoteService) {
        this.quoteService = quoteService;
    }

    @GetMapping(value = "/")
    public List<Quote> getAllQuotes() {
        return quoteService.findAllQuotes();
    }

    @GetMapping(value = "/{id}")
    public Quote getQuoteById(@PathVariable("id") Integer id) {
        return quoteService.findQuoteById(id);
    }


}
