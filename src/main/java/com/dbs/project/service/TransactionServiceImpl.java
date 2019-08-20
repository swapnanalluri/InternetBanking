package com.dbs.project.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.project.model.Customer;
import com.dbs.project.model.Transaction;
import com.dbs.project.repository.TransactionRepository;
@Service
public class TransactionServiceImpl implements TransactionService {
	
	@Autowired
	public TransactionRepository transactionRepository;
	
	@Override
	@Transactional
	public List<Transaction> listAll() {

		return this.transactionRepository.findAll();
	}

}
