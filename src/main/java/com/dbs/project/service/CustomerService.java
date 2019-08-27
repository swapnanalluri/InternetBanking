package com.dbs.project.service;

import java.util.List;
import java.util.Optional;

import com.dbs.project.model.Customer;
import com.dbs.project.model.Transaction;

public interface CustomerService {
	
	List<Customer> listAll();
	
	Customer findById(long cusid);
	Optional<Customer> findByUsernameAndPassword(String username,String password);
	Customer save(Customer customer);
	void deleteById(long id);
  
	Customer updateCustomer(long cusid, Customer customer);
	Transaction saveTransaction(Transaction transaction);


		
}
