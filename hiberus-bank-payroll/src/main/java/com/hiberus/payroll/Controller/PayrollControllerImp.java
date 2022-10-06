package com.hiberus.payroll.Controller;


import javax.print.DocFlavor.STRING;
import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PutMapping;

import com.hiberus.payroll.Service.PayrollService;

import org.springframework.stereotype.Controller;

@Controller
public class PayrollControllerImp {

    @Autowired
    PayrollService payrollService;

   @PutMapping(value="/pay")
   public ResponseEntity<?>payroll(@QueryParam("dni")String dni,@QueryParam("salary") float salary){

    if(payrollService.pay(dni, salary)){
        return new ResponseEntity<String>("La nomina ha sido pagada correctamente", HttpStatus.OK);
    }
    return new ResponseEntity<String>("El pago no se ha efectuado", HttpStatus.INTERNAL_SERVER_ERROR);
   }

    
}
