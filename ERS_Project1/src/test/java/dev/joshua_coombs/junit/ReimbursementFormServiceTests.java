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
import dev.joshua_coombs.services.ReimbursementFormService;

@ExtendWith(MockitoExtension.class)
public class ReimbursementFormServiceTests {
	@InjectMocks
	ReimbursementFormService rfs;
	
	@Mock
	ReimbursementFormDAO rfdMock;
	
	@BeforeEach
	public void setup() {
		rfs = new ReimbursementFormService(rfdMock);
	}
	
	@Test
	public void validCreateRF() {
		Timestamp ts = Timestamp.valueOf("2022-07-05 04:01:15");
		ReimbursementForm rfMock = new ReimbursementForm(1, 1, "First", "Last",
			ts, "Phoenix", "description", 200, "letter",
			"prep", "A", "justification", 150, 
			"pending");
		when(rfdMock.createRF(rfMock)).thenReturn(rfMock);
		ReimbursementForm success = rfs.createRF(rfMock);
		assertEquals(rfMock, success);
	}
	
	@Test
	public void invalidCreateRFNull() {
		
		when(rfdMock.createRF(null)).thenReturn(null);
		ReimbursementForm success = rfs.createRF(null);
		assertEquals(null, success);
	}
	
	@Test
	public void validGetAllReimbursementRequests() {
		Timestamp ts = Timestamp.valueOf("2022-07-05 04:01:15");
		ReimbursementForm rfMockOne = new ReimbursementForm(1, 1, "First", "Last",
				ts, "Phoenix", "description", 200, "letter",
				"prep", "A", "justification", 150, 
				"pending");
		ReimbursementForm rfMockTwo = new ReimbursementForm(2, 2, "First", "Last",
				ts, "Phoenix", "description", 200, "letter",
				"prep", "A", "justification", 150, 
				"pending");
		List<ReimbursementForm> list = new ArrayList();
		list.add(rfMockOne);
		list.add(rfMockTwo);
		when(rfdMock.getAllReimbursementRequests()).thenReturn(list);
		rfs.createRF(rfMockOne);
		rfs.createRF(rfMockTwo);
		List<ReimbursementForm> success = rfs.getAllReimbursementRequests();
		assertEquals(list, success);
	}
	
	@Test
	public void validGetSpecificReimbursementRequest() {
		Timestamp ts = Timestamp.valueOf("2022-07-05 04:01:15");
		ReimbursementForm rfMockOne = new ReimbursementForm(1, 1, "First", "Last",
				ts, "Phoenix", "description", 200, "letter",
				"prep", "A", "justification", 150, 
				"pending");
		when(rfdMock.getSpecificReimbursementRequest(1)).thenReturn(rfMockOne);
		rfs.createRF(rfMockOne);
		ReimbursementForm success = rfs.getSpecificReimbursementRequest(1);
		assertEquals(rfMockOne, success);
	}
	
	@Test
	public void invalidGetSpecificReimbursementRequest() {
		when(rfdMock.getSpecificReimbursementRequest(1)).thenReturn(null);
		ReimbursementForm failure = rfs.getSpecificReimbursementRequest(1);
		assertEquals(null, failure);
	}
	
	@Test
	public void validGetAllRequestsFromSpecificEmployee() {
		Timestamp ts = Timestamp.valueOf("2022-07-05 04:01:15");
		ReimbursementForm rfMockOne = new ReimbursementForm(1, 1, "First", "Last",
				ts, "Phoenix", "description", 200, "letter",
				"prep", "A", "justification", 150, 
				"pending");
		ReimbursementForm rfMockTwo = new ReimbursementForm(2, 1, "First", "Last",
				ts, "Phoenix", "description", 200, "letter",
				"prep", "A", "justification", 150, 
				"pending");
		List<ReimbursementForm> list = new ArrayList();
		list.add(rfMockOne);
		list.add(rfMockTwo);
		when(rfdMock.getAllRequestsFromSpecificEmployee(1)).thenReturn(list);
		rfs.createRF(rfMockOne);
		rfs.createRF(rfMockTwo);
		List<ReimbursementForm> success = rfs.getAllRequestsFromSpecificEmployee(1);
		assertEquals(list, success);
	}
	
	@Test
	public void invalidGetAllRequestsFromSpecificEmployee() {
		when(rfdMock.getAllRequestsFromSpecificEmployee(1)).thenReturn(null);
		List<ReimbursementForm> failure = rfs.getAllRequestsFromSpecificEmployee(1);
		assertEquals(null, failure);
	}
	
	@Test
	public void validCancelReimbursementRequest() {
		Timestamp ts = Timestamp.valueOf("2022-07-05 04:01:15");
		ReimbursementForm rfMockOne = new ReimbursementForm(1, 1, "First", "Last",
				ts, "Phoenix", "description", 200, "letter",
				"prep", "A", "justification", 150, 
				"pending");
		ReimbursementForm rfMockTwo = new ReimbursementForm(1, 1, "First", "Last",
				ts, "Phoenix", "description", 200, "letter",
				"prep", "A", "justification", 150, 
				"cancelled");
		when(rfdMock.cancelReimbursementRequest(1)).thenReturn(rfMockTwo);
		rfs.createRF(rfMockOne);
		ReimbursementForm success = rfs.cancelReimbursementRequest(1);
		assertEquals(rfMockTwo, success);
	}
	
	@Test
	public void invalidCancelReimbursementRequest() {
		when(rfdMock.cancelReimbursementRequest(1)).thenReturn(null);
		ReimbursementForm failure = rfs.cancelReimbursementRequest(1);
		assertEquals(null, failure);
	}
	
	@Test
	public void validUpdateReimbursementStatus() {
		Timestamp ts = Timestamp.valueOf("2022-07-05 04:01:15");
		ReimbursementForm rfMockOne = new ReimbursementForm(1, 1, "First", "Last",
				ts, "Phoenix", "description", 200, "letter",
				"prep", "A", "justification", 150, 
				"pending");
		ReimbursementForm rfMockTwo = new ReimbursementForm(1, 1, "First", "Last",
				ts, "Phoenix", "description", 200, "letter",
				"prep", "A", "justification", 150, 
				"approved");
		when(rfdMock.updateReimbursementStatus("approved", 1)).thenReturn(rfMockTwo);
		rfs.createRF(rfMockOne);
		ReimbursementForm success = rfs.updateReimbursementStatus("approved", 1);
		assertEquals(rfMockTwo, success);
	}
	
	@Test
	public void invalidUpdateReimbursementStatus() {
		when(rfdMock.updateReimbursementStatus("approved", 1)).thenReturn(null);
		ReimbursementForm failure = rfs.updateReimbursementStatus("approved", 1);
		assertEquals(null, failure);
	}
	
	@Test
	public void validUpdateReimbursementAmount() {
		Timestamp ts = Timestamp.valueOf("2022-07-05 04:01:15");
		ReimbursementForm rfMockOne = new ReimbursementForm(1, 1, "First", "Last",
				ts, "Phoenix", "description", 200, "letter",
				"prep", "A", "justification", 150, 
				"pending");
		ReimbursementForm rfMockTwo = new ReimbursementForm(1, 1, "First", "Last",
				ts, "Phoenix", "description", 200, "letter",
				"prep", "A", "justification", 175, 
				"pending");
		when(rfdMock.updateReimbursementAmount(175, 1)).thenReturn(rfMockTwo);
		rfs.createRF(rfMockOne);
		ReimbursementForm success = rfs.updateReimbursementAmount(175, 1);
		assertEquals(rfMockTwo, success);
	}
	
	@Test
	public void invalidUpdateReimbursementAmount() {
		when(rfdMock.updateReimbursementAmount(175, 1)).thenReturn(null);
		ReimbursementForm failure = rfs.updateReimbursementAmount(175, 1);
		assertEquals(null, failure);
	}
	
	@Test
	public void validUpdateGrade() {
		Timestamp ts = Timestamp.valueOf("2022-07-05 04:01:15");
		ReimbursementForm rfMockOne = new ReimbursementForm(1, 1, "First", "Last",
				ts, "Phoenix", "description", 200, "letter",
				"prep", "A", "justification", 150, 
				"pending");
		ReimbursementForm rfMockTwo = new ReimbursementForm(1, 1, "First", "Last",
				ts, "Phoenix", "description", 200, "letter",
				"prep", "B", "justification", 150, 
				"pending");
		when(rfdMock.updateGrade("B", 1)).thenReturn(rfMockTwo);
		rfs.createRF(rfMockOne);
		ReimbursementForm success = rfs.updateGrade("B", 1);
		assertEquals(rfMockTwo, success);
	}
	
	@Test
	public void invalidUpdateGrade() {
		when(rfdMock.updateGrade("B", 1)).thenReturn(null);
		ReimbursementForm failure = rfs.updateGrade("B", 1);
		assertEquals(null, failure);
	}
}
