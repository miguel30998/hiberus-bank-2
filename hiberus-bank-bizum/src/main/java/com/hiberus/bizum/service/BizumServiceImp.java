package com.hiberus.bizum.service;

import javax.ws.rs.GET;

import org.springframework.stereotype.Service;

import com.hiberus.bizum.Utils.Conexion;

@Service
public class BizumServiceImp implements BizumService {

    @Override
    public boolean payBizum(String receiver, float cuantity, String sender) {

        String Urlpay="http://127.0.0.1:8082/pay?dni="+sender+"&salary="+cuantity;
        String Urlreceive="http://127.0.0.1:8082/receive?dni="+receiver+"&salary="+cuantity;
        try {
            Conexion.peticionHttpGet(null, Urlpay, "PUT");
            Conexion.peticionHttpGet(null, Urlreceive, "PUT");
        } catch (Exception e) {
        
        }


    }
    @Override
    public boolean bizumHandler(String receiver, float cuantity, String sender) {
       String urlreceiver="http://127.0.0.1:8082/balance/"+receiver;
       String urlsender="http://127.0.0.1:8082/balance/"+sender;
       try{
           float balancesender= Float.valueOf(Conexion.peticionHttpGet(null, urlsender,"GET"));
           float balancereceiver=Float.valueOf(Conexion.peticionHttpGet(null, urlsender,"GET"));

           if(balancesender>cuantity){
                payBizum(receiver, cuantity, sender);
           }
           if(balanceCheck(receiver, balancereceiver+cuantity)){
                
                
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
    
}
