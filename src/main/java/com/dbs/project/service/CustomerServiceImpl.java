package com.dbs.project.service;

import java.util.List;
import java.util.Optional;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.dbs.project.model.Customer;
import com.dbs.project.model.Transaction;
import com.dbs.project.repository.CustomerRepository;
import com.dbs.project.repository.TransactionRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	public CustomerRepository customerRepository;
	@Autowired
	public TransactionRepository transactionRepository;
	
	


	@Autowired
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@Override
	@Transactional
	public List<Customer> listAll() {

		return this.customerRepository.findAll();
	}

	@Override
	@Transactional
	public Customer findById(long cusid) {
		Optional<Customer> customer=customerRepository.findById(cusid);
		if(customer.isPresent())
		{
			return customer.get();
		}
		System.out.println("nullllll");
		return null;
	}

	@Override
	@Transactional
	public Customer save(Customer customer) {

		return this.customerRepository.save(customer);
	}
	
	@Override
    @Transactional
    public Customer updateCustomer(long cusid,Customer customer) {
		
    	Customer customer1 = customerRepository.findById(cusid).get();
    	customer1.setName(customer.getName());
    	customer1.setUserName(customer.getUserName());
    	customer1.setPassword(customer.getPassword());
    	customer1.setPhoneNo(customer.getPhoneNo());
    	customer1.setPan(customer.getPan());
    	customer1.setAddress(customer.getAddress());
    	
    	return customerRepository.save(customer1);
    	
    }

	@Override
	@Transactional
	public void deleteById(long id) {
		this.customerRepository.deleteById(id);
		
	}

	@Override
	@Transactional
	public Customer findByUsernameAndPassword(String username, String password) {
		
		return this.customerRepository.findByUserNameAndPassword(username,password).get();
	}

	

	@Override
	@Transactional
	public Transaction saveTransaction(Transaction transaction) {
		 return this.transactionRepository.save(transaction);
	}

	
	

}
