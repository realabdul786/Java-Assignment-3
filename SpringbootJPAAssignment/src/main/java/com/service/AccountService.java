package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Account;
import com.repository.AccountRepository;

@Service
public class AccountService {
	
	@Autowired
	AccountRepository repo;
	
	public String createAccount(Account account) {
		
		Optional<Account> result = repo.findById(account.getAccNumber());
		
		if(result.isPresent() && account.getAmount() > 1000) {
			return "Account Num shoud be unique/Amount Should greater than 1000";
		} else {
			repo.save(account);
		    return "Account Created!!";
		}
	}
	
	public String depositAmount(Account account) {
		Float amount = account.getAmount();
		if(amount> 50000) {
			return "please provide PAN";
		} else {
			repo.save(account);
			return "Deposit Done. available amount is " + account.getAmount();
		}
	}
	
	public String withdraw(Account account) {
		Optional<Account> result = repo.findById(account.getAccNumber());
		if(result.isPresent()) {
			Account acc = result.get();
			if(acc.getAmount() > 1000 && account.getAmount() < acc.getAmount()) {
				return "Withdraw done";
			} else {
				return "Amount less than 1000 or no balance";
			}
		} else {
			return "Acccount does't exist";
		}
	}
	
	public String checkBalance(int accNumber) {
		Optional<Account> result = repo.findById(accNumber);
		if(result.isEmpty()) {
			Account account = result.get();
			return "Balance is" + account.getAmount();
		} else {
			return "Acccount does't exist";
		}
		
	}
	
	public List<Account> findAllAccounts() {
		return repo.findAll();
}
	
	public Account findAccountByAccNum(int accNum) {
		return repo.findById(accNum).get();
	}
	


}
