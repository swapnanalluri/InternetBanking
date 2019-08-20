package com.dbs.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.project.model.Transaction;

import com.dbs.project.service.TransactionService;

@CrossOrigin
@RestController

@RequestMapping("/api/v3")
public class TransactionController {

	@Autowired
	TransactionService transactionService;
	
	@GetMapping("/transactions")
	public List<Transaction> listAllTransactions(){
		return transactionService.listAll();
	}
	
}
