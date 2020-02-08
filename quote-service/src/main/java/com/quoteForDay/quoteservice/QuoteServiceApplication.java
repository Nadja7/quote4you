package com.quoteForDay.quoteservice;

import com.quoteForDay.quoteservice.dto.QuoteRepository;
import com.quoteForDay.quoteservice.model.Quote;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class QuoteServiceApplication {
	private static final Logger log = LoggerFactory.getLogger(QuoteServiceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(QuoteServiceApplication.class, args);
	}
	@Bean
	public CommandLineRunner demo(QuoteRepository repository) {
		return (args) -> {
		Quote quote= repository.findById(1);
			log.info("Quote found with findById(1L):");
			log.info("--------------------------------");
			log.info(quote.toString());
			log.info("");
		};
	}

}


