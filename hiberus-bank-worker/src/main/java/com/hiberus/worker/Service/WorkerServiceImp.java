package com.hiberus.worker.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Service;

import com.hiberus.worker.domain.dao.Worker;
import com.hiberus.worker.domain.dto.BodyWorker;
import com.hiberus.worker.repository.WorkerRepository;

@Service
public class WorkerServiceImp implements WorkerService{
    @Autowired
    WorkerRepository workerRepository;

    @Override
    public Worker convertirWorker(BodyWorker bodyWorker) {
        Worker worker=new Worker(bodyWorker);
        return worker;
    }
    @Override
    public Worker conseguirWorkerDni(String dni){
        try{
            Worker worker = workerRepository.findByDni(dni);
            System.out.println(worker.toString());
            return worker;
        }catch(NullPointerException e){
            System.out.println("null");
            return null;
        }
    }
    @Override
    public boolean comprobarSiExisteWorker(Worker worker) {
        try{
            Worker workerAux = workerRepository.findByDni(worker.getDni());
            if(workerAux.equals(worker)){
                return true;
            }return false;
        }catch(NullPointerException e ){
            return false;
        }
    }
    @Override
    public boolean darAltaService(BodyWorker bodyWorker) {
        Worker worker = new Worker(bodyWorker);
       
        if(!comprobarSiExisteWorker(worker)){
            try{
                workerRepository.save(worker);
                return true;
            }catch(JpaSystemException e){
               return false;
            }
        }   
        return false;
    }   
    public boolean darBajaService(Worker worker) {
        if(comprobarSiExisteWorker(worker)){
            try{
                workerRepository.delete(worker);
                return true;
            }catch(JpaSystemException e){
                return false;
            }
        }
        return false; 
    }
}

