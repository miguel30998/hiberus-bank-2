package com.hiberus.worker.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hiberus.worker.domain.dao.Worker;
import com.hiberus.worker.repository.WorkerRepository;

@Service
public class SalaryServiceImp implements SalaryService{
    
    @Autowired
    WorkerService workerService;
    @Autowired
    WorkerRepository workerRepository;


    @Override
    public boolean subirSalario(String dni, float salary) {
       Worker worker= workerService.conseguirWorkerDni(dni);
       if(workerService.comprobarSiExisteWorker(worker)){
         if(worker.getSalary()<salary){
                worker.setSalary(salary);
         }
        workerRepository.save(worker);
       }
        return false;
    }



    
}
