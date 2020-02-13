package com.quoteForDay.dayservice.controller;

import com.quoteForDay.dayservice.dto.DayRepository;
import com.quoteForDay.dayservice.model.Day;
import com.quoteForDay.dayservice.service.QuoteServiceClient;
import com.quoteForDay.quoteservice.model.Quote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Random;

@Controller
public class DayController {


    @Autowired
    DayRepository dayRepository;

    @Autowired
    QuoteServiceClient quoteServiceClient;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homeForm(Model model) {
        List<Day> days = dayRepository.findAll();
        model.addAttribute("daysForm", days);
        return "home";
    }

    @RequestMapping(value = "/generate", method = RequestMethod.GET)
    public String generateQuote(Model model) {

        Random random = new Random();
        int randomWithNextInt = random.nextInt(6);
        Quote quoteId = quoteServiceClient.getQuoteById(randomWithNextInt);
        model.addAttribute("quotes", quoteId);

        return "quotes";
    }

}

