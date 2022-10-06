package com.hiberus.worker.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hiberus.worker.domain.dao.Worker;
import com.hiberus.worker.repository.WorkerRepository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Service
public class BalanceServiceImp implements BalanceService{

    @Autowired
    WorkerService workerService;
    @Autowired
    WorkerRepository workerRepository;

    private static final  Logger log = LogManager.getLogger(Worker.class);
    @Override
    public boolean uploadBalance(String dni, float money, boolean method) {
        Worker worker =workerService.conseguirWorkerDni(dni);
        if(method==false){
            worker.setBalance(worker.getBalance()+money);
            workerRepository.save(worker);
            return true;
        }
        if(worker.getBalance()<money){
            log.error("No tiene suficiente dinero para pagar");
            return false;
        }
        worker.setBalance(worker.getBalance()-money);
        workerRepository.save(worker);
        return true;
    }
    
}
