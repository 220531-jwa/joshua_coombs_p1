package dev.joshua_coombs.services;

import java.util.List;
import dev.joshua_coombs.models.*;
import dev.joshua_coombs.repositories.*;

public class AccountService {
	private static AccountDAO accountDao;
	
	public AccountService(AccountDAO accountDao) {
		this.accountDao = accountDao;
	}
	
	public Account login(String username, String password) {
		Account a = accountDao.getAccountByUsername(username);
		if (a != null) {
			if (a.getPassword().equals(password)) {
				return a;
			}
		}
		return null;
	}
	
	/*
	public Account createAccount(Account a) {
		Account newAccount = accountDao.createAccount(a);
		return newAccount;
	}
	*/
	
	public Account updateReimbursementAvailable(int id) {
		Account updatedAccount = accountDao.updateReimbursementAvailable(id);
		return updatedAccount;
	}
	
	/*
	public Account changePassword(int id, String password) {
		Account changedPassword = accountDao.changePassword(id, password);
		return changedPassword;
	}
	*/
}
