package com.hiberus.worker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hiberus.worker.domain.dao.Worker;

@Repository
public interface WorkerRepository  extends JpaRepository<Worker, String>{
    
    
    Worker findByDni(@Param("dni") String dni);
    
}
