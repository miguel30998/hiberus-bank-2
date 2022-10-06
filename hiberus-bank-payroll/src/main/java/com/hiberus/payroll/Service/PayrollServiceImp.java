package com.hiberus.payroll.Service;

import org.springframework.stereotype.Service;

import com.hiberus.payroll.Utils.Conexion;

@Service
public class PayrollServiceImp implements PayrollService{
    private static String url="http://127.0.0.1:8082/pay?dni=";

    @Override
    public boolean pay(String dni, float Salary) {

        try {
            Conexion.peticionHttpGet(null,url+dni+"&salary="+Salary);
            return true;
        } catch (Exception e) {
            
            return false;
        }
    }


    
    
}
