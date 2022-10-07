package com.hiberus.payroll.Controller;

import javax.print.DocFlavor.STRING;
import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.hiberus.payroll.Service.PayrollService;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Controller
public class PayrollControllerImp {

    @Autowired
    PayrollService payrollService;

    private static final  Logger log = LogManager.getLogger(PayrollController.class);

   @PutMapping(value="/pay")
   public ResponseEntity<?>payroll(@QueryParam("dni")String dni,@QueryParam("salary") float salary,@RequestHeader(value="Authorization")
   String Authorization){
    if(!"Gandalf".equals(Authorization)){
        log.error("Han intentado acceder a un campo restringido sin autorizacion");
        return new ResponseEntity<String>("Acceso denegado",HttpStatus.BAD_REQUEST);
    }
    if(payrollService.pay(dni, salary, Authorization)){
        return new ResponseEntity<String>("La nomina ha sido pagada correctamente", HttpStatus.OK);
    }
    return new ResponseEntity<String>("El pago no se ha efectuado", HttpStatus.INTERNAL_SERVER_ERROR);
   }

    
}
