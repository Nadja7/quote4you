package com.quoteForDay.dayservice.service;

import com.quoteForDay.quoteservice.model.Quote;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@FeignClient(name = "quote-service", configuration = QuoteServiceClientConfiguration.class, fallback = QuoteServiceClientFallback.class)

public interface QuoteServiceClient {

    @RequestMapping(value = "/{id}")
    Quote getQuoteById(@PathVariable("id") int id);


}
