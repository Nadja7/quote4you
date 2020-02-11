package com.quoteForDay.quoteservice.dto;

import com.quoteForDay.quoteservice.model.Quote;
import org.bouncycastle.jcajce.provider.asymmetric.rsa.CipherSpi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;


    @Repository
    public interface  QuoteRepository extends JpaRepository<Quote, Long> {

    Optional<Quote> findAllByDayId(int dayId);
    }


