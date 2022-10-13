package com.hiberus.bizum.service;

import java.util.List;

import com.hiberus.bizum.domain.dao.Bizum;

public interface BizumService {

    boolean payBizum(String receiver, float cuantity, String sender);
    boolean bizumHandler(String receiver, float cuantity, String sender);
    List<Bizum> getBizums(String dni);
    
}
