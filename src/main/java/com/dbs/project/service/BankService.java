package com.dbs.project.service;

import java.util.List;
import java.util.Optional;

import com.dbs.project.model.Bank;
import com.dbs.project.model.Customer;

public interface BankService {
	
	Bank findByUsername(String username);
	
	Bank findByPassword(String password);
	
	Customer findById(long cusid);
	
	List<Customer> listAll();


	Customer save(Customer customer);

	//Customer createCustomer(Customer customer);
	
	Customer updateCustomer(long cusid, Customer customer);
	
	void deleteCustomerById(long cusid);
	
	//void deleteAccount(long id,long aid);
	Optional<Bank> findByUsernameAndPassword(String username,String password);
	void deleteAccount(long aid);
}
