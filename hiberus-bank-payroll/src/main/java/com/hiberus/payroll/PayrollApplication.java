package com.hiberus.payroll;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class PayrollApplication {
    public static void main(final String[] args) {
        SpringApplication.run(PayrollApplication.class, args);
    }
}
