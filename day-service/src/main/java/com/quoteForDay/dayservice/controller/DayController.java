package com.quoteForDay.dayservice.controller;
import com.quoteForDay.dayservice.dto.DayRepository;
import com.quoteForDay.dayservice.service.QuoteServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

   @Controller
    public class DayController {


      @Autowired
       DayRepository dayRepository;

       @Autowired
       QuoteServiceClient quoteServiceClient;

        @RequestMapping(value = "/")
        public String showAll(Model model) {
            model.addAttribute("days",dayRepository.findAll());
            return "home";
        }

        @RequestMapping(value = "/yourQuote/{id}")
        public String getYourQuote(Model model,@PathVariable("id") int id) {
            model.addAttribute("quotes",quoteServiceClient.findQuotesByDayId(id));
            return "quotes";
        }



    }

