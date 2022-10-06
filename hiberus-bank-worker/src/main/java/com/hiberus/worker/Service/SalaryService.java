package com.hiberus.worker.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hiberus.worker.domain.dao.Worker;
@Service
public interface SalaryService {

    boolean subirSalario(String dni,float salary);
    
}
