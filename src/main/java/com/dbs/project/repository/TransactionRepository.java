package com.dbs.project.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dbs.project.model.Transaction;
import com.dbs.project.model.*;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
	
	 Optional<Transaction> findByReferenceno(long reference_no);
	 
	List<Transaction> findAll();
	
	@Query(value = "select * from transaction where status= 'Success' and from_account_no= :givenacnum or to_account_no= :givenacnum order by referenceno desc limit 10", nativeQuery = true)
	 ArrayList<Transaction> getTransactions(@Param("givenacnum") Long gacnumber);

}
