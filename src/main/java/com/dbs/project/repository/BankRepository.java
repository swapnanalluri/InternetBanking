package com.dbs.project.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dbs.project.model.Bank;


public interface BankRepository extends JpaRepository<Bank, Long> {
	
	Bank findByUsername(String name);
	Bank findByPassword(String password);
	List<Bank> findAll();

}
