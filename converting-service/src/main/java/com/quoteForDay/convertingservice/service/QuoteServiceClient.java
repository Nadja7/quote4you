package com.quoteForDay.convertingservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;


@FeignClient(name = "quote-service")
public interface QuoteServiceClient {

    @RequestMapping(value = "/")
    String findAllQuotes();


}
