package com.dbs.project.model;

import lombok.Data;

import javax.persistence.*;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table
public class Customer implements Serializable, Comparable<Customer> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long cid;

	@Column(name = "customername", nullable = false)
	private String name;

	@Column(name = "username", unique=true,nullable = false)
	private String userName;

	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "pan", nullable = false)
	private String pan;

	@Column(name = "phoneno", nullable = false)
	private String phoneNo;

	@Column(name = "address", nullable = false)
	private String address;

	private String city;
    private String state;
    private String zip;

	@JsonIgnore
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<BankAccounts> bankAccountsSet = new HashSet<>();

	public Customer() {

	}
	public Customer(String name, String userName, String password, String pan, String phoneNo, String address,
			String city, String state, String zip) {
		super();
		this.name = name;
		this.userName = userName;
		this.password = password;
		this.pan = pan;
		this.phoneNo = phoneNo;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
	

	@Override
	public int compareTo(Customer customer) {
		return (int) (this.cid - customer.cid);
	}

	public void addBankAccounts(BankAccounts bankAccounts) {
		this.bankAccountsSet.add(bankAccounts);
		bankAccounts.setCustomer(this);
	}


}
