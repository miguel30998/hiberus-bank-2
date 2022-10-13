package com.hiberus.bizum.domain.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="Bizum")
@Getter
@Setter
public class Bizum {

    @Id
    @GeneratedValue(generator="UUID")
    @GenericGenerator(
            name="UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    String id;
    String receiver;
    float cuantity;
    String sender;
    

    public Bizum(){}


    public Bizum(String receiver, float cuantity, String sender) {
        this.receiver = receiver;
        this.cuantity = cuantity;
        this.sender = sender;
    }


    @Override
    public String toString() {
        return "Bizum [id=" + id + ", receiver=" + receiver + ", cuantity=" + cuantity + ", sender=" + sender + "]";
    }
    

    
}
