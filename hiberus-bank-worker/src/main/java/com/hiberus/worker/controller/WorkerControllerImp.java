package com.hiberus.worker.controller;

import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.hiberus.worker.Service.WorkerService;
import com.hiberus.worker.Service.WorkerServiceImp;
import com.hiberus.worker.domain.dao.Worker;
import com.hiberus.worker.domain.dto.BodyWorker;
import com.hiberus.worker.repository.WorkerRepository;

@Controller
public class WorkerControllerImp implements WorkerController{
    @Autowired
    WorkerRepository workerRepository;
    @Autowired
    WorkerServiceImp workerService;

    @Override
    @PutMapping(path ="/baja/{dni}")
    public ResponseEntity<String> sack(@PathVariable String dni){
        if(workerService.darBajaService(workerService.conseguirWorkerDni(dni))){
            return new ResponseEntity<>("El trabajador ha sido borrado correctamente", HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>("El trabajador no ha sido borrado",HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    @PutMapping(path ="/alta")
    public ResponseEntity<String> hire(@RequestBody BodyWorker bodyWorker){
        
        if(workerService.darAltaService(bodyWorker)){
            return new ResponseEntity<>("El trabajador ha sido guardado correctamente", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("El trabajador no ha sido creado",HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @Override
    @GetMapping(path="/get")
    public ResponseEntity<BodyWorker>showWorker(@QueryParam(value="dni") String dni){
        Worker worker =workerService.conseguirWorkerDni(dni);
     
        BodyWorker bodyWorker=new BodyWorker(worker);
        return new ResponseEntity<BodyWorker>(bodyWorker,HttpStatus.ACCEPTED);
    }
    
}
