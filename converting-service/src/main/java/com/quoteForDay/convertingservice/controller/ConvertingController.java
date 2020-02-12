package com.quoteForDay.convertingservice.controller;

import com.quoteForDay.convertingservice.service.QuoteServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.*;

@Controller
public class ConvertingController {

    @Autowired
    QuoteServiceClient quoteServiceClient;

    @RequestMapping(value = "/",method = RequestMethod.GET)
        public String packYourQuote(Model model) {

        String quotes= quoteServiceClient.findAllQuotes();
        model.addAttribute("quotes",quotes);

        File file = new File("text.txt");

        try (Writer writer = new BufferedWriter(new FileWriter(file))) {
            String contents = quotes;
            if(file.exists()){
            writer.write(contents);
            System.out.print("exists");
                             }
            else {
                file.createNewFile();
                System.out.print("not exists");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        model.addAttribute("file",  file);
        return "view";

        }

    }

