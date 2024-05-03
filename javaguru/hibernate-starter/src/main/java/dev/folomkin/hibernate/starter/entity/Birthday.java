package dev.folomkin.hibernate.starter.entity;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public record Birthday(LocalDate birthDate) {

    private long getAge() {
        return ChronoUnit.YEARS.between(birthDate, LocalDate.now());
    }
}
