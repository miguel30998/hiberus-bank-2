package com.hiberus.bizum.domain.dao;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="Bizum")
@Getter
@Setter
public class Bizum {

    @Id
    String id;
    String receiver;
    float cuantity;
    String sender;
    

    public Bizum(){}


    public Bizum(String id, String receiver, float cuantity, String sender) {
        this.id = id;
        this.receiver = receiver;
        this.cuantity = cuantity;
        this.sender = sender;
    }


    
}
