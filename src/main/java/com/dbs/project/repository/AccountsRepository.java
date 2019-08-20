package com.dbs.project.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dbs.project.model.BankAccounts;

public interface AccountsRepository extends JpaRepository<BankAccounts, Long> {
	
	BankAccounts findByAcnumber(long acnumber);

}
