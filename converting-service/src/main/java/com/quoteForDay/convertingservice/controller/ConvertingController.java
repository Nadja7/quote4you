package com.quoteForDay.convertingservice.controller;

import com.quoteForDay.convertingservice.service.QuoteServiceClient;
import com.quoteForDay.quoteservice.model.Quote;
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

    @Autowired
    QuoteServiceClient quoteServiceClient;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {

        return "home";
    }

    @RequestMapping(value = "/pack", method = RequestMethod.GET)

    public String packYourQuote(Model model) {
        List<String> quotesToStrings = new ArrayList<>();
        List<Quote> quotes = quoteServiceClient.findAllQuotes();

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
                System.out.print(" file exists");
            } else {
                file.createNewFile();
                System.out.print("not exists");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        model.addAttribute("file", file);
        return "view";

    }


}



