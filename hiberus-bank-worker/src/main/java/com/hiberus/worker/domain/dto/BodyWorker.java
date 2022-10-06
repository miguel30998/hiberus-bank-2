package com.hiberus.worker.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hiberus.worker.domain.dao.Worker;

import lombok.Getter;

@Getter
public class BodyWorker {
    @JsonProperty("dni")
    String DNI;
    @JsonProperty("name")
    String name;
    @JsonProperty("surname")
    String surname;
    @JsonProperty("salary")
    float salary;
    @JsonProperty("balance")
    float balance=0;
    public BodyWorker(String Dni,String name, String surname, float salary, float balance) {
        this.DNI= Dni;
        this.name = name;
        this.surname = surname;
        this.salary = salary;
        this.balance = balance;
    }

    public BodyWorker(Worker worker){
        this.DNI= worker.getDni();
        this.name = worker.getName();
        this.surname = worker.getSurname();
        this.salary = worker.getSalary();
        this.balance = worker.getBalance();
    }
    @Override
    public String toString() {
        return "BodyWorker [DNI=" + DNI + ", name=" + name + ", surname=" + surname + ", salary=" + salary
                + ", balance=" + balance + "]";
    }
    
    
}
