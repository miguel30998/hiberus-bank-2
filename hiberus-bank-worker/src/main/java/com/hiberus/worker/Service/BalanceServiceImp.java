package com.hiberus.worker.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hiberus.worker.domain.dao.Worker;
import com.hiberus.worker.repository.WorkerRepository;

import javassist.bytecode.stackmap.BasicBlock.Catch;

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
    @Override
    public float getBalanceWorker(String dni) {
        try{
        Worker worker = workerRepository.findByDni(dni);
        
        return worker.getBalance();
        }catch(NullPointerException e){
            return 0;
        }
    }
    @Override
    public boolean setBalanceWorker(String dni,float money){
        try{
            Worker worker =workerRepository.findByDni(dni);
            worker.setBalance(money);
            workerRepository.save(worker);
            return true;
        }catch(NullPointerException e){
            log.error("Error durante la busqueda de un worker segun su dni");
            return false;
        }
    }
}
    

