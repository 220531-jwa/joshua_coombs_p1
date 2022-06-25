package dev.joshua_coombs.services;

import java.util.List;
import dev.joshua_coombs.models.*;
import dev.joshua_coombs.repositories.*;

public class AccountService {
	private static AccountDAO accountDao = new AccountDAO();
	
	public Account login(String username, String password) {
		Account a = accountDao.getAccountByUsername(username);
		if (a.getPassword().equals(password)) {
			return a;
		}
		return null;
	}
}
