package com.quoteForDay.convertingservice.service;

import com.quoteForDay.quoteservice.model.Quote;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(name = "quote-service")
public interface QuoteService {

    @RequestMapping(value = "/")
    List<Quote> findAllQuotes();

}
