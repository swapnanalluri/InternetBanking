package com.dbs.project.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dbs.project.model.BankAccounts;
import com.dbs.project.model.Customer;
import com.dbs.project.model.Transaction;
import com.dbs.project.service.BankAccountsService;
import com.dbs.project.service.BankService;
import com.dbs.project.service.CustomerService;
import com.dbs.project.service.TransactionService;

import org.springframework.web.bind.annotation.RequestParam;

@CrossOrigin
@RestController

@RequestMapping("/api/v1")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@Autowired
	BankAccountsService bankaccountsservice;
	
	@Autowired
	TransactionService transactionservice;
	
	@Autowired
	private BankService bankService;

	@GetMapping("/customer")
	public List<Customer> listAllCustomers() {
		return customerService.listAll();
	}

	@GetMapping("/customer/{id}")
	public Customer listCustomerById(@PathVariable long id) {
		return customerService.findById(id);
	}
	@GetMapping("/customer/{username}/{password}")
	public Optional<Customer> getCustomerByUserNameAndPassword(@PathVariable("username") String username,@PathVariable("password") String password) {
		return customerService.findByUsernameAndPassword(username,password);
	}

	@GetMapping("/customer/{id}/accounts")
	public Set<BankAccounts> getCustomerAccount(@PathVariable long id) {

		return this.customerService.findById(id).getBankAccountsSet();

	}

	@PutMapping("customer/{id}/update")
	public Customer update(@PathVariable("id") Long id, @Valid @RequestBody Customer customer) {
		return this.customerService.updateCustomer(id, customer);
	}

	@PostMapping("/transactions")
	public Transaction fundTransfer(@RequestBody Transaction transaction) {

		long fromacc = transaction.getFromAccountNo();
		long toacc = transaction.getToAccountNo();
		String ifsc=transaction.getIfsc();
		long sumamount;
		if(transactionservice.getSumOfBalance(fromacc)==null){
			sumamount=0;
		}
		else {
			sumamount=transactionservice.getSumOfBalance(fromacc);
		}
		BankAccounts ba1 = bankaccountsservice.findByAcNumber(fromacc);
		BankAccounts ba2 = bankaccountsservice.findByAcNumber(toacc);
		BankAccounts ba3 = bankaccountsservice.findByIfscAndAcnumber(ifsc, toacc);
		double enteredAmount = transaction.getAmount();
		
		if(ba2==null || ba3==null || enteredAmount>ba1.getBalance() || ba1.getBalance()-enteredAmount<5000)
		{
			transaction.setStatus("Failed");
		}
		else if(sumamount+enteredAmount>10000)
		{
			transaction.setStatus("Pending");
		}
		else {
			double amount1 = ba1.getBalance() - enteredAmount;
			double amount2 = ba2.getBalance() + enteredAmount;
		ba1.setBalance(amount1);
		ba2.setBalance(amount2);
		transaction.setStatus("Success");
		}
		return this.customerService.saveTransaction(transaction);
	}

	

	
}
