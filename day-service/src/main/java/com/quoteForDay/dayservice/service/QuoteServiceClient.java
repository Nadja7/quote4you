package com.quoteForDay.dayservice.service;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name="quote-service",fallback = QuoteServiceClientFallback.class)

public interface QuoteServiceClient {

    @RequestMapping(value="/quoteByDayId/{day_id}")
     String findQuotesByDayId(@PathVariable("day_id") int id);


}
