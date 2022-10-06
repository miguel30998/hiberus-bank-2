package com.hiberus.payroll.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


public interface PayrollController {


    @ApiOperation(value="Pagar nomina")
    @ApiResponses({
        @ApiResponse(code=201,message = "El pago de la nomina ha sido efectuado correctamente")
    })
    ResponseEntity<?>pagarNomina(String dni, float salario);

    
}
