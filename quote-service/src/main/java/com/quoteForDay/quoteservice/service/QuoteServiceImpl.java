package com.quoteForDay.quoteservice.service;

import com.quoteForDay.quoteservice.dto.QuoteRepository;
import com.quoteForDay.quoteservice.model.Quote;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuoteServiceImpl {

    private final QuoteRepository quoteRepository;

    public QuoteServiceImpl(QuoteRepository quoteRepository) {
        this.quoteRepository = quoteRepository;
    }

    public List<Quote> findAllQuotes() {
        return quoteRepository.findAll();
    }

    public Quote findQuoteById(Integer id) {
        return quoteRepository.findById(id);
    }


}
