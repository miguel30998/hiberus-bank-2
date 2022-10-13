package com.hiberus.worker.controller;

import org.springframework.http.ResponseEntity;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

public interface BalanceController {
    @ApiOperation(value="Pagar")
    @ApiResponses({
        @ApiResponse(code=201, message="El dinero ha sido quitado correctamente")
    })
    ResponseEntity<?>pay(String dni, float salary);

    @ApiOperation(value="Comprobar balance")
    @ApiResponses({
        @ApiResponse(code=201, message="El balance ha sido mostrado correctamente")
    })
    ResponseEntity<?>getWorkerBalance(String dni);

    @ApiOperation(value="Recibir")
    @ApiResponses({
        @ApiResponse(code=201, message="El dinero ha sido añadido correctamente")
    })
    ResponseEntity<?>receive(String dni, float salary);
    @ApiOperation(value="Settear balance")
    @ApiResponses({
        @ApiResponse(code=201,message="El balance ha sido cambiado correctamente ")
    })
    ResponseEntity<?>set(String dni,float money);
}
