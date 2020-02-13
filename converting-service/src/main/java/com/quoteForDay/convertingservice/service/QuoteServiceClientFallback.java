package com.quoteForDay.convertingservice.service;


import org.springframework.stereotype.Component;

@Component
public class QuoteServiceClientFallback implements QuoteServiceClient {

    @Override
    public String findAllQuotes() {
        return "Seems to be that quote-service is dead... try to reconnect";
    }

}
