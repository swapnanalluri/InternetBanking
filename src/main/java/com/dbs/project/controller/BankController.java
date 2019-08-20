package com.dbs.project.controller;

import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.dbs.project.model.Bank;
import com.dbs.project.model.BankAccounts;
import com.dbs.project.model.Customer;
import com.dbs.project.repository.BankRepository;
import com.dbs.project.service.BankAccountsService;
import com.dbs.project.service.BankService;

@CrossOrigin
@RestController
@RequestMapping("api/v2")
public class BankController {

	@Autowired
	private BankService bankService;

	@Autowired
	private BankRepository bankRepository;

	@Autowired
	private BankAccountsService bankAccountsService;

	@PostMapping("/login")
	public String loginpost(

			@RequestParam("username") String username, @RequestParam("password") String password, Model model) {
		Bank b1 = bankService.findByUsername(username);
		Bank b2 = bankService.findByPassword(password);

		if (b1 != null && b2 != null && b1.equals(b2)) {
			model.addAttribute("user", username);
			return "success";
		}
		return "login";
	}

	@PostMapping("/customers/create")
	public Customer create(@RequestBody Customer customer) {
		return this.bankService.save(customer);

	}

	@PutMapping("customers/update/{id}")
	public Customer update(@PathVariable("id") Long id, @RequestBody Customer customer) {
		return this.bankService.updateCustomer(id, customer);
	}

	@DeleteMapping("customers/delete/{id}")
	public void delete(@PathVariable("id") Long cusid) {
		this.bankService.deleteCustomerById(cusid);
	}

	@GetMapping("/customers/accounts/{id}")
	public Set<BankAccounts> getCustomerAccount(@PathVariable long id) {
		return this.bankService.findById(id).getBankAccountsSet();
	}

	@PostMapping("/customers/accounts/{id}")
	public void setCustomerAccount(@PathVariable long id, @RequestBody BankAccounts bankAccount) {
		Customer customer = this.bankService.findById(id);
		customer.addBankAccounts(bankAccount);
		this.bankService.save(customer);
	}

	@GetMapping("customers/listAll")
	public List<Customer> getCustomers() {
		return this.bankService.listAll();
	}

	@DeleteMapping("/customers/close/{aid}")
	public void closeAccounts(@PathVariable long aid) {
		this.bankService.deleteAccount(aid);
	}
}