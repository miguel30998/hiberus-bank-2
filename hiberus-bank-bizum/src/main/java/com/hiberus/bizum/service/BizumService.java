package com.hiberus.bizum.service;

public interface BizumService {

    boolean payBizum(String receiver, float cuantity, String sender);
    boolean bizumHandler(String receiver, float cuantity, String sender);
    
}
