package com.hiberus.bizum.service;

import java.util.List;

import javax.ws.rs.GET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hiberus.bizum.Utils.Conexion;
import com.hiberus.bizum.domain.dao.Bizum;
import com.hiberus.bizum.repository.BizumRepository;

@Service
public class BizumServiceImp implements BizumService {

    @Autowired
    BizumRepository bizumRepository;

    @Override
    public boolean payBizum(String receiver, float cuantity, String sender) {

        String Urlpay="http://127.0.0.1:8082/pay?dni="+sender+"&salary="+cuantity;
        String Urlreceive="http://127.0.0.1:8082/receive?dni="+receiver+"&salary="+cuantity;
        Bizum bizum =new Bizum(receiver,cuantity,sender);
        try {
            Conexion.peticionHttpGet(null, Urlpay, "PUT");
            Conexion.peticionHttpGet(null, Urlreceive, "PUT");
            bizumRepository.save(bizum);
            return true;
        } catch (Exception e) {
        return false;
        }
    }
    @Override
    public boolean bizumHandler(String receiver, float cuantity, String sender) {
       String urlreceiver="http://127.0.0.1:8082/balance/"+receiver;
       String urlsender="http://127.0.0.1:8082/balance/"+sender;
       float balancesender;
       float balancereceiver;
       try{
           balancesender= Float.valueOf(Conexion.peticionHttpGet(null, urlsender,"GET"));
           balancereceiver=Float.valueOf(Conexion.peticionHttpGet(null, urlsender,"GET"));

           if(balancesender>cuantity){
                payBizum(receiver, cuantity, sender);
           if(!balanceCheck(receiver, balancereceiver+cuantity) || !balanceCheck(sender, balancereceiver-cuantity) ){
                payBizum(sender, cuantity, receiver);
           }
        }
       }catch(Exception e ){
            return false;
       }
            return false;
    }
    private boolean balanceCheck(String dni,float cuantity) throws NumberFormatException, Exception{
        String url="http://127.0.0.1:8082/balance/"+dni;
        float balanceaux=Float.valueOf(Conexion.peticionHttpGet(null, url,"GET"));
        if(balanceaux==cuantity){
            return true;
        }
        return false;
    }
    @Override
    public List<Bizum> getBizums(String dni) {
        List<Bizum> list =bizumRepository.findByreceiver(dni);
        list.addAll(bizumRepository.findBysender(dni));
        return list;
    }
    
}
