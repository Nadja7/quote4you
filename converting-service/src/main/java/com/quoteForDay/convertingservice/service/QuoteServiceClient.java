package com.quoteForDay.convertingservice.service;

import com.quoteForDay.quoteservice.model.Quote;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@FeignClient(name = "quote-service")
@Service
public interface QuoteServiceClient {

    @RequestMapping(value = "/")
    List<Quote> findAllQuotes();


}
