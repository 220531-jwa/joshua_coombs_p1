package dev.joshua_coombs.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dev.joshua_coombs.models.*;
import dev.joshua_coombs.repositories.*;

public class ReimbursementFormService {
	private static ReimbursementFormDAO rfDao;
	
	public ReimbursementFormService(ReimbursementFormDAO rfDao) {
		this.rfDao = rfDao;
	}
	
	public ReimbursementForm createRF(ReimbursementForm rf) {
		ReimbursementForm newRf = rfDao.createRF(rf);
		return newRf;
	}
	
	public List<ReimbursementForm> getAllReimbursementRequests() {
		List<ReimbursementForm> rfForms = rfDao.getAllReimbursementRequests();
		return rfForms;
	}
	
	public ReimbursementForm getSpecificReimbursementRequest(int rId) {
		ReimbursementForm rf = rfDao.getSpecificReimbursementRequest(rId);
		return rf;
	}
	
	public List<ReimbursementForm> getAllRequestsFromSpecificEmployee(int eId) {
		List<ReimbursementForm> rfForms = rfDao.getAllRequestsFromSpecificEmployee(eId);
		return rfForms;
	}
	
	public ReimbursementForm cancelReimbursementRequest(int rId) {
		ReimbursementForm rf = rfDao.cancelReimbursementRequest(rId);
		return rf;
	}
	
	public ReimbursementForm updateReimbursementStatus(String updateStatus, int rId) {
		ReimbursementForm rf = rfDao.updateReimbursementStatus(updateStatus, rId);
		return rf;
	}
	
	public ReimbursementForm updateReimbursementAmount(int updateAmount, int rId) {
		ReimbursementForm rf = rfDao.updateReimbursementAmount(updateAmount, rId);
		return rf;
	}
	
	public ReimbursementForm updateGrade(String newGrade, int rId) {
		ReimbursementForm rf = rfDao.updateGrade(newGrade, rId);
		return rf;
	}
}
