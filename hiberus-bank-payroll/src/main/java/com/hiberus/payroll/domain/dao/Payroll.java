package com.hiberus.payroll.domain.dao;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="payroll")
@Getter
@Setter
public class Payroll {
  
    String date;
    @Id
    String dni;
    float salary;
    
    public Payroll(){}

    public Payroll( String dni, float salary){
        String pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'";
        String dateAux = DateTimeFormatter.ofPattern(pattern).format(LocalDateTime.now());
        this.date=dateAux;
        this.salary=salary;
        this.dni=dni;
    }
    
}
