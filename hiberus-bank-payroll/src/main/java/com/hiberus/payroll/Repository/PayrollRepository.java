package com.hiberus.payroll.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hiberus.payroll.domain.dao.Payroll;

public interface PayrollRepository  extends JpaRepository<Payroll, String>{
    
}
