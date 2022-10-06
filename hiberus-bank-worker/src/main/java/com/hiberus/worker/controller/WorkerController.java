package com.hiberus.worker.controller;

import org.springframework.http.ResponseEntity;

import com.hiberus.worker.domain.dto.BodyWorker;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

public interface WorkerController {
    
    @ApiOperation(value = "Dar de baja trabajadores")
    @ApiResponses({
        @ApiResponse(code =201, message= "Se ha dado de baja correctamente al trabajador")
    })
    ResponseEntity<?> sack(String Dni);

    @ApiOperation(value = "Dar de alta trabajadores")
    @ApiResponses({
        @ApiResponse(code =201, message="Se ha dado de alta correctamente al trabajador")
    })
    ResponseEntity<?> hire(BodyWorker bodyWorker);

    @ApiOperation(value="Devolver un trabajador por el dni")
    @ApiResponses({
        @ApiResponse(code=201,message = "El trabajador ha sido devuelto")
    })
    ResponseEntity<BodyWorker>showWorker(String dni);
}
