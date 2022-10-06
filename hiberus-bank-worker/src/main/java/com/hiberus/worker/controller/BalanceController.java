package com.hiberus.worker.controller;

import org.springframework.http.ResponseEntity;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

public interface BalanceController {
    @ApiOperation(value="Pagar nomina")
    @ApiResponses({
        @ApiResponse(code=201, message="La nomina ha sido pagada correctamente")
    })
    ResponseEntity<?>pay(String dni, float salary);
    
}
