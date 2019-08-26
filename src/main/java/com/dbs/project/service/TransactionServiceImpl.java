package com.dbs.project.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
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

	@Override
	@Transactional
	public List<Transaction> listAllten(long acnum) {
		return this.transactionRepository.getTransactions(acnum);
	}

	@Override
	public Long getSumOfBalance(long acnum) {
		String date1=LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
		return this.transactionRepository.getSumOfBalance(acnum, date1);
	}

	

}
