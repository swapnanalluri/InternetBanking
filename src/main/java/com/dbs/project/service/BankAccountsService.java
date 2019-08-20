package com.dbs.project.service;

import java.util.List;

import com.dbs.project.model.BankAccounts;

public interface BankAccountsService {
	List<BankAccounts> listAll();

	BankAccounts saveAccount(BankAccounts accounts);

	BankAccounts findById(long id);

	BankAccounts updateAccount(long id, BankAccounts account);

	void deleteAccount(long id);
	BankAccounts findByAcNumber(long acnumber);

}
