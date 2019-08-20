package com.dbs.project.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.project.model.BankAccounts;
import com.dbs.project.repository.AccountsRepository;

@Service
public class BankAccountsServiceImpl implements BankAccountsService{

	@Autowired
	private AccountsRepository accountRepository;
	
    @Autowired
	public BankAccountsServiceImpl(AccountsRepository accountRepository) {
    	super();
		this.accountRepository = accountRepository;
	}
    
	@Override
	@Transactional
	public List<BankAccounts> listAll() {
		return this.accountRepository.findAll();
	}

	@Override
	@Transactional
	public BankAccounts saveAccount(BankAccounts account) {
		return this.accountRepository.save(account);
	}

	@Override
	@Transactional
	public BankAccounts findById(long id) {
		return accountRepository.findById(id).get();
	}

	@Override
	@Transactional
	public BankAccounts updateAccount(long id, BankAccounts account) {
		BankAccounts ba = accountRepository.findById(id).get();
		account.setAcnumber(account.getAcnumber());
		account.setBranch(account.getBranch());
		account.setIfsc(account.getIfsc());
		return accountRepository.save(account);
	}

	@Override
	@Transactional
	public void deleteAccount(long id) {
		this.accountRepository.deleteById(id);
		
	}

	@Override
	@Transactional
	public BankAccounts findByAcNumber(long acnumber) {
		return this.accountRepository.findByAcnumber(acnumber);
	}

}
