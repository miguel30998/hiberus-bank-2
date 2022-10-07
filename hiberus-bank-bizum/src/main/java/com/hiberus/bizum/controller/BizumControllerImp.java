package com.hiberus.bizum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.hiberus.bizum.service.BizumService;

@Controller
public class BizumControllerImp implements BizumController{

    @Autowired
    BizumService bizumService;

    @Override
    public ResponseEntity<?> doBizum(String receiver, float cuantity, String sender) {
       
        if(bizumService.payBizum(receiver,cuantity,sender)){
                return null;
        }
        return null;
    }
    
}
