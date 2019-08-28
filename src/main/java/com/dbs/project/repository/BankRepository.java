package com.dbs.project.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dbs.project.model.Bank;
import com.dbs.project.model.Customer;


public interface BankRepository extends JpaRepository<Bank, Long> {
	
	Bank findByUsername(String name);
	Bank findByPassword(String password);
	List<Bank> findAll();
	Optional<Bank> findByUsernameAndPassword(String username, String password);

}
