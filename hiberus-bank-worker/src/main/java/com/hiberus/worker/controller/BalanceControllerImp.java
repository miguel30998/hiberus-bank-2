package com.hiberus.worker.controller;

import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PutMapping;

import com.hiberus.worker.Service.BalanceService;

@Controller
public class BalanceControllerImp {

    @Autowired
    BalanceService balanceService;
    
    @PutMapping("/pay")
    public ResponseEntity<Boolean>pay(@QueryParam("dni")String dni,@QueryParam("salary")float salary){

        if(balanceService.uploadBalance(dni, salary, false)){
            return new ResponseEntity<Boolean>(true,HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<Boolean>(false,HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
}
