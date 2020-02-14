package com.quoteForDay.convertingservice.controller;

import com.quoteForDay.convertingservice.service.QuoteServiceImpl;
import com.quoteForDay.quoteservice.model.Quote;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ConvertingController {

    Logger logger = LoggerFactory.getLogger(ConvertingController.class);

    @Autowired
    QuoteServiceImpl quoteService;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {

        return "home";
    }

    @RequestMapping(value = "/pack", method = RequestMethod.GET)

    public String packYourQuote(Model model) {
        List<String> quotesToStrings = new ArrayList<>();
        List<Quote> quotes = quoteService.findAllQuotes();

        for (Quote quote : quotes) {
            quotesToStrings.add(quote.toString());
        }
        File file = new File("quotes.txt");

        try (Writer writer = new BufferedWriter(new FileWriter(file))) {
            List<String> contents = quotesToStrings;
            if (file.exists()) {
                for (String str : contents) {
                    writer.write(str + System.lineSeparator());
                }
                logger.info("file is succefully created", file.getName());
            } else {
                file.createNewFile();
                logger.info("creation failed", file.getName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        model.addAttribute("file", file);
        return "view";

    }


}



