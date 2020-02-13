package com.quoteForDay.quoteservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "c_quote")
@lombok.Getter
@lombok.Setter
public class Quote {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    private String quote;

    private String autor;

    private int dayId;

    public Quote(Integer id, String quote, String autor, int dayId) {
        this.id = id;
        this.quote = quote;
        this.autor = autor;
        this.dayId = dayId;
    }

    public Quote() {
    }


    @Override
    public String toString() {
        return String.format(
                "Customer[id=%d, quote='%s',autor='%s']",
                id, quote, autor);
    }

}

