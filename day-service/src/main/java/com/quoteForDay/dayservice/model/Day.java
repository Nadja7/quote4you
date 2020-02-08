package com.quoteForDay.dayservice.model;
import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "c_day")
@lombok.Getter
@lombok.Setter
public class Day {


        @Id
        @GeneratedValue(strategy = IDENTITY)
        private Long id;

        private String day_desc;

        Day(Long id, String day_desc) {
            this.id=id;
            this.day_desc=day_desc;
        }

        Day () {};

}

