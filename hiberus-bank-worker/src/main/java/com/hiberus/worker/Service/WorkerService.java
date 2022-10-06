package com.hiberus.worker.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.hiberus.worker.domain.dao.Worker;
import com.hiberus.worker.domain.dto.BodyWorker;

public interface WorkerService {

    Worker convertirWorker(BodyWorker bodyWorker);
    boolean comprobarSiExisteWorker(Worker worker);
    boolean darAltaService(BodyWorker Bodyworker);
    Worker conseguirWorkerDni(String dni);
}
