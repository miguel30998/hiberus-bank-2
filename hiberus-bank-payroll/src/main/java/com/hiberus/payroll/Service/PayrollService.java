package com.hiberus.payroll.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public interface PayrollService {

    boolean pay(String dni, float Salary,String token);
    
}
