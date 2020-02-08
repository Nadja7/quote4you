package com.quoteForDay.dayservice.controller;


import com.quoteForDay.dayservice.dto.DayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.time.LocalDate;

   @Controller
    public class DayController {


      @Autowired
       DayRepository dayRepository;

        @RequestMapping(value = "/", method = RequestMethod.GET)
        public String showAll(Model model) {
            LocalDate localDate = LocalDate.now();
            model.addAttribute("time",localDate);
            model.addAttribute("days",dayRepository.findAll());

            return "home";
        }



    }

