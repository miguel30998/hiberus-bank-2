package com.hiberus.bizum.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hiberus.bizum.domain.dao.Bizum;

public interface BizumRepository  extends JpaRepository<Bizum, String>{
    
}
