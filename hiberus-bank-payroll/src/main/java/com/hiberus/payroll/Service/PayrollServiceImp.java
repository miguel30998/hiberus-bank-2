package com.hiberus.payroll.Service;

import org.springframework.stereotype.Service;

import com.hiberus.payroll.Utils.Conexion;

@Service
public class PayrollServiceImp implements PayrollService{
    private static String url="http://127.0.0.1:8082/receive?dni=";

    @Override
    public boolean pay(String dni, float Salary,String token) {
        Salary =Salary-(Salary*0.0525f);

        try {
            Conexion.peticionHttpGet(token,url+dni+"&salary="+Salary);
            return true;
        } catch (Exception e) {
            
            return false;
        }
    }


    
    
}
