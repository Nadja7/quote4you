package com.quoteForDay.dayservice.controller;
import com.quoteForDay.dayservice.dto.DayRepository;
import com.quoteForDay.dayservice.model.Day;
import com.quoteForDay.dayservice.service.QuoteServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Controller
    public class DayController {


      @Autowired
       DayRepository dayRepository;

       @Autowired
       QuoteServiceClient quoteServiceClient;

        @RequestMapping(value = "/",method = RequestMethod.GET)
        public String homeForm(Model model) {
            List <Day> days= dayRepository.findAll();
            model.addAttribute("daysForm", days);
            return "home";
        }


    @RequestMapping(value = "/yourQuote/{day_id}")
    public String getYourQuoteByDayId(Model model,@PathVariable("day_id") int id) {
        model.addAttribute("quotes",quoteServiceClient.findQuotesByDayId(id));
        return "quotes";
    }


    @RequestMapping(value = "/generate",method = RequestMethod.GET)
    public String generateQuote(Model model) {

        Random random = new Random();
        int randomWithNextInt = random.nextInt(6);
            String quoteId=quoteServiceClient.findQuotesByDayId(randomWithNextInt);
            model.addAttribute("quotes",quoteId);

        return "quotes";
    }

    @PostMapping("/form")
    public String submissionResult(@ModelAttribute("daysForm") Day day, Model model) {

        int dayId=day.getId();
        String quoteByDay=quoteServiceClient.findQuotesByDayId(dayId);
        System.out.print(quoteByDay);
        model.addAttribute("dayId",quoteByDay);

        return "result";
    }

    }

