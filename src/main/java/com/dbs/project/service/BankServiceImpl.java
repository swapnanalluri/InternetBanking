package com.dbs.project.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.project.model.Bank;
import com.dbs.project.model.Customer;
import com.dbs.project.repository.AccountsRepository;
import com.dbs.project.repository.BankRepository;
import com.dbs.project.repository.CustomerRepository;

@Service
public class BankServiceImpl implements BankService {

	@Autowired
	private BankRepository bankRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private AccountsRepository accountsRepository;

	@Autowired
	public BankServiceImpl(BankRepository bankRepository) {
		this.bankRepository = bankRepository;
	}

	@Override
	@Transactional
	public Bank findByUsername(String username) {
		return this.bankRepository.findByUsername(username);
	}

	@Override
	public Bank findByPassword(String password) {
		return this.bankRepository.findByPassword(password);
	}

	@Override
	@Transactional
	public List<Customer> listAll() {
		return this.customerRepository.findAll();
	}

	@Override
	@Transactional
	public Customer findById(long cusid) {
		return this.customerRepository.findById(cusid).get();
	}

	@Override
	@Transactional
	public Customer save(Customer customer) {

		return this.customerRepository.save(customer);
	}

	@Override
	@Transactional
	public Customer updateCustomer(long cusid, Customer customer) {

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
	public void deleteCustomerById(long cusid) {
		this.customerRepository.deleteById(cusid);
	}

	@Override
	@Transactional
	public void deleteAccount(long aid) {
		this.accountsRepository.deleteById(aid);

	}

}
