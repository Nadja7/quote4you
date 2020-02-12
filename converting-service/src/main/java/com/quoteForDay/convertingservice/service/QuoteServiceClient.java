package com.quoteForDay.convertingservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

@RestController
@FeignClient(name="quote-service")
public interface QuoteServiceClient {

        @RequestMapping(value = "/",produces = "application/json")
        String findAllQuotes();

}
