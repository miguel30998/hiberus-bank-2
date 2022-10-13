package com.hiberus.bizum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.hiberus.bizum.domain.dao.Bizum;

public interface BizumRepository  extends JpaRepository<Bizum, String>{
    
    List<Bizum>findByreceiver(@Param("receiver")String receiver);
    List<Bizum>findBysender(@Param("sender")String sender);
}
