package com.quoteForDay.dayservice.service;

import com.quoteForDay.quoteservice.model.Quote;
import org.springframework.stereotype.Component;

@Component
public class QuoteServiceClientFallback implements QuoteServiceClient {

    @Override
    public Quote getQuoteById(int id) {
        Quote fallBack = new Quote(0, "Default quote", "Default autor", 0);
        return fallBack;
    }

}
