package com.hiberus.payroll.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hiberus.payroll.Repository.PayrollRepository;
import com.hiberus.payroll.Utils.Conexion;
import com.hiberus.payroll.domain.dao.Payroll;

@Service
public class PayrollServiceImp implements PayrollService{
    private static String url="http://127.0.0.1:8082/receive?dni=";

    @Autowired
    PayrollRepository PayrollRepository;

    @Override
    public boolean pay(String dni, float Salary,String token) {
        Salary =Salary-(Salary*0.0525f);

        try {
            Conexion.peticionHttpGet(token,url+dni+"&salary="+Salary);
            Payroll payroll = new Payroll(dni,Salary);
            PayrollRepository.save(payroll);
            return true;
        } catch (Exception e) {
            
            return false;
        }
    }


    
    
}
