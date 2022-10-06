package com.hiberus.worker.domain.dao;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.hiberus.worker.domain.dto.BodyWorker;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;



@Entity
@Table(name ="worker")
@Getter
@Setter
public class Worker {
    @Id
    String dni;
    String name;
    String surname;
    float salary;
    float balance=0;
 
    private static final  Logger log = LogManager.getLogger(Worker.class);
    public Worker() {
    }
    public Worker(String Dni,String name, String surname, float salary, float balance) {
        this.dni= Dni;
        this.name = name;
        this.surname = surname;
        this.salary = salary;
        this.balance = balance;
    }
    public Worker(BodyWorker bodyWorker){
        this.dni=bodyWorker.getDNI();
        this.name=bodyWorker.getName();
        this.salary=bodyWorker.getSalary();
        if(bodyWorker.getSalary()<0){
            this.salary=0;
            log.error("El salario introducido es menor que 0, se pondra a 0 para el trabajador"+this.dni);
        }
        
        this.surname=bodyWorker.getSurname();
        this.balance=bodyWorker.getBalance();
    }
    @Override
    public String toString() {
        return "Worker [DNI=" + dni + ", name=" + name + ", surname=" + surname + ", salary=" + salary + ", balance="
                + balance + "]";
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((dni == null) ? 0 : dni.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((surname == null) ? 0 : surname.hashCode());
        result = prime * result + Float.floatToIntBits(salary);
        result = prime * result + Float.floatToIntBits(balance);
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Worker other = (Worker) obj;
        if (dni == null) {
            if (other.dni != null)
                return false;
        } else if (!dni.equals(other.dni))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (surname == null) {
            if (other.surname != null)
                return false;
        } else if (!surname.equals(other.surname))
            return false;
        if (Float.floatToIntBits(salary) != Float.floatToIntBits(other.salary))
            return false;
        if (Float.floatToIntBits(balance) != Float.floatToIntBits(other.balance))
            return false;
        return true;
    }

    
    
}
