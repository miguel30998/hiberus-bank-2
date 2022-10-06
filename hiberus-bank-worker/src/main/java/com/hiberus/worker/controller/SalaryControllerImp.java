package com.hiberus.worker.controller;

import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PutMapping;

import com.hiberus.worker.Service.SalaryService;

@Controller
public class SalaryControllerImp implements SalaryController{

     @Autowired
     SalaryService salaryService;

    @Override
    @PutMapping(value="/salary")
    public ResponseEntity<String>uploadSalary(@QueryParam("DNI")String dni,@QueryParam("salary")float salary){
        if(salaryService.subirSalario(dni, salary)){
            return new ResponseEntity<>("El salario ha sido actualizado de forma correcta",HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>("No se ha podido actualizar el salario",HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
