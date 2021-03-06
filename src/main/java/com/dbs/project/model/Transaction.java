package com.dbs.project.model;

import javax.persistence.*;

import lombok.Data;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
@Data
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long referenceno;
	private long fromAccountNo;
	private long toAccountNo;
	private long amount;
	private String ifsc;
	private String date = LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
	private String status;
	public Transaction() {

	}

	public Transaction(long fromAccountNo, long toAccountNo, long amount, String ifsc,String status) {
		super();
		this.fromAccountNo = fromAccountNo;
		this.toAccountNo = toAccountNo;
		this.amount = amount;
		this.ifsc = ifsc;
		this.status=status;

	}

}
