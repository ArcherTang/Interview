package com.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.entity.Bpi;

@Repository
public interface BpiRepository extends JpaRepository<Bpi, Long>{
	long deleteByCode(String code);
}
