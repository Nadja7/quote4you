package com.quoteForDay.convertingservice.service;

import com.quoteForDay.quoteservice.model.Quote;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service

public class QuoteServiceImpl implements QuoteService {

    Logger logger = LoggerFactory.getLogger(QuoteServiceImpl.class);
    @Autowired
    QuoteService quoteService;

    @Retryable(
            value = {SQLException.class},
            maxAttempts = 2,
            backoff = @Backoff(delay = 5000))
    @RequestMapping(value = "/")
    public List<Quote> findAllQuotes() {

        return quoteService.findAllQuotes();
    }


    @Recover
    List<Quote> fallback(Throwable e) {
        logger.info("returning name from fallback method");
        List<Quote> fallBackQuote = new ArrayList<>();
        for (Quote quote : fallBackQuote) {

            Quote fallBack1 = new Quote(0, "default", "default", 0);
            fallBackQuote.add(fallBack1);
        }
        return fallBackQuote;
    }


}