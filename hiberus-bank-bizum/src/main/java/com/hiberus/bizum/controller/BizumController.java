package com.hiberus.bizum.controller;

import org.springframework.http.ResponseEntity;

public interface BizumController {


    ResponseEntity<?>doBizum(String receiver,float cuantity,String sender);
    public ResponseEntity<?>bizums(String dni);
}
