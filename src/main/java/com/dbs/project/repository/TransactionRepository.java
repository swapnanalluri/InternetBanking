package com.dbs.project.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dbs.project.model.Transaction;
import com.dbs.project.model.*;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
	
	 Optional<Transaction> findByReferenceno(long reference_no);
	 
	List<Transaction> findAll();

}
