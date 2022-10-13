package com.hiberus.worker.controller;

import javax.ws.rs.HeaderParam;
import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import com.hiberus.worker.Service.BalanceService;

import io.swagger.annotations.Authorization;

@Controller
public class BalanceControllerImp implements BalanceController {

    @Autowired
    BalanceService balanceService;
    
    @Override
    @PutMapping("/receive")
    public ResponseEntity<Boolean>receive(@QueryParam("dni")String dni,@QueryParam("salary")float salary){
    
        if(balanceService.uploadBalance(dni, salary, false)){
            return new ResponseEntity<Boolean>(true,HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<Boolean>(false,HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @Override
    @GetMapping("/balance/{dni}")
    public ResponseEntity<?>getWorkerBalance(@PathVariable String dni){
        
        float balance=balanceService.getBalanceWorker(dni);
        if(0==balance){
            return new ResponseEntity<String>("No he conseguido acceder a la base de datos",HttpStatus.INTERNAL_SERVER_ERROR);
        }
            return new ResponseEntity<Float>(balance,HttpStatus.ACCEPTED);

    }
    @Override
    @PutMapping("/pay")
    public ResponseEntity<Boolean>pay(@QueryParam("dni")String dni,@QueryParam("salary")float salary){

        if(balanceService.uploadBalance(dni, salary, true)){
            return new ResponseEntity<Boolean>(true,HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<Boolean>(false, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @Override
    @PutMapping("/set")
    public ResponseEntity<Boolean>set(@QueryParam("dni")String dni,@QueryParam("salary")float salary){
        if(balanceService.setBalanceWorker(dni, salary)){
            return new ResponseEntity<Boolean>(true,HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<Boolean>(false,HttpStatus.INTERNAL_SERVER_ERROR);
    }  
}
