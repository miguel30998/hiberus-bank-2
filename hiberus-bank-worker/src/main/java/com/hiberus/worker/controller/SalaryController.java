package com.hiberus.worker.controller;

import org.springframework.http.ResponseEntity;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

public interface SalaryController {

    @ApiOperation(value = "Dar de alta trabajadores")
    @ApiResponses({
        @ApiResponse(code =201, message="Se ha dado de alta correctamente al trabajador")
    })
    ResponseEntity<?> uploadSalary(String dni,float salary);
    
}
