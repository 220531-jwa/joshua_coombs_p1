package dev.joshua_coombs.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import dev.joshua_coombs.models.*;
import dev.joshua_coombs.repositories.*;
import dev.joshua_coombs.services.AccountService;

@ExtendWith(MockitoExtension.class)
public class AccountServiceTests {
	@InjectMocks
	AccountService as;
	
	@Mock
	AccountDAO adMock;
	
	@BeforeEach
	public void setup() {
		as = new AccountService(adMock);
	}
	
	@Test
	public void validLoginEmployee() {
		Account mockAccount = new Account(1, "Mock", "Name", "username", "password", 1000, "employee");
		when(adMock.getAccountByUsername("username")).thenReturn(mockAccount);
		Account success = as.login("username", "password");
		assertEquals(mockAccount, success);
	}
	
	@Test
	public void validLoginFinanceManager() {
		Account mockAccount = new Account(1, "Mock", "Name", "username", "password", 1000, "finance_manager");
		when(adMock.getAccountByUsername("username")).thenReturn(mockAccount);
		Account success = as.login("username", "password");
		assertEquals(mockAccount, success);
	}
	
	@Test
	public void invalidLoginNullAccount() {
		when(adMock.getAccountByUsername(anyString())).thenReturn(null);
		Account failure = as.login("no", "user");
		assertEquals(null, failure);
	}
	
	@Test
	public void invalidLoginWrongPassword() {
		Account mockAccount = new Account(1, "Mock", "Name", "username", "password", 1000, "employee");
		when(adMock.getAccountByUsername("username")).thenReturn(mockAccount);
		Account failure = as.login("username", "word");
		assertEquals(null, failure);
	}
	
	@Test
	public void validUpdateReimbursementAvailable() {
		Account mockAccount = new Account(1, "Mock", "Name", "username", "password", 1000, "employee");
		when(adMock.updateReimbursementAvailable(1)).thenReturn(mockAccount);
		Account success = as.updateReimbursementAvailable(1);
		assertEquals(mockAccount, success);
	}
	
	@Test
	public void invalidUpdateReimbursementAvailable() {
		when(adMock.updateReimbursementAvailable(1)).thenReturn(null);
		Account failure = as.updateReimbursementAvailable(1);
		assertEquals(null, failure);
	}
}
