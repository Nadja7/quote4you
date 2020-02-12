package com.quoteForDay.dayservice.service;
import org.springframework.stereotype.Component;

@Component
public class QuoteServiceClientFallback  implements QuoteServiceClient {

    @Override
    public String findQuotesByDayId(int id) {
        return "Error during retrieving  quotes for day-service.";
    }

}

