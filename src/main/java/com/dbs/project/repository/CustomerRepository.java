package com.dbs.project.repository;

import com.dbs.project.model.Customer;
import com.dbs.project.model.Transaction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	List<Customer> findAll();

	Optional<Customer> findByPassword(String password);

	void save(Transaction transaction);

	Optional<Customer> findByUserName(String username);

}
