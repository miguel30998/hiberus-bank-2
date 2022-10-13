package com.hiberus.bizum.controller;

import java.util.List;

import javax.sound.midi.Receiver;
import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.hiberus.bizum.domain.dao.Bizum;
import com.hiberus.bizum.service.BizumService;

@Controller
public class BizumControllerImp implements BizumController{

    @Autowired
    BizumService bizumService;

    @Override
    @PutMapping(value="/bizum")
    public ResponseEntity<?> doBizum(@QueryParam("receiver")String receiver,@QueryParam("cuantity") float cuantity,@QueryParam("sender") String sender) {
       
        if(bizumService.payBizum(receiver,cuantity,sender)){
                return new ResponseEntity<String>("El bizum se ha hecho correctamente",HttpStatus.ACCEPTED);
        }
         return new ResponseEntity<String>("El bizum ha fallado",HttpStatus.ACCEPTED);
    }
    @Override
    @GetMapping("/get")
    public ResponseEntity<?>bizums(@QueryParam("dni")String dni){

       List<Bizum> list = bizumService.getBizums(dni);

       return new ResponseEntity<String>("Estos son los bizum realizados o recibidos por"+dni+"\n"+list.toString(),HttpStatus.ACCEPTED);

        
    }
    
}
