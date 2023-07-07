package com.example.ebanking.service;

import com.example.ebanking.entity.BankAccount;

import java.math.BigInteger;
import java.util.List;

public interface BankAccountService {
	public BankAccount findByAccountNo(BigInteger accountno);
	List<BankAccount> findAll(BigInteger accountNo);
	public BankAccount save(BankAccount theBankAccount);
	public void updateCardDetails(Long id, BigInteger accountNo);
}
