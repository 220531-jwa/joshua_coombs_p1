package dev.joshua_coombs.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dev.joshua_coombs.models.*;
import dev.joshua_coombs.utils.ConnectionUtil;

public class ReimbursementFormDAO {
	private static ConnectionUtil cu = ConnectionUtil.getConnectionUtil();
	
	public ReimbursementForm createRF(ReimbursementForm rf) {
		String sql = "insert into ers.r_form values "
				+ "(default, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) returning *;";
		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, rf.getReimbursementId());
			ps.setString(2, rf.getEmployeeFirstName());
			ps.setString(3, rf.getEmployeeLastName());
			ps.setTimestamp(4, rf.getDateAndTime());
			ps.setString(5,  rf.getLocation());
			ps.setString(6, rf.getDescription());
			ps.setInt(7, rf.getCost());
			ps.setString(8, rf.getGradingFormat());
			ps.setString(9, rf.getEventType());
			ps.setString(10, rf.getJustification());
			ps.setInt(11, rf.getReimbursementAmount());
			ps.setString(12, rf.getReimbursementStatus());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return new ReimbursementForm(
						rs.getInt("e_id"),
						rs.getInt("r_id"),
						rs.getString("first_name"),
						rs.getString("last_name"),
						rs.getTimestamp("date_time"),
						rs.getString("loc"),
						rs.getString("description"),
						rs.getInt("r_cost"),
						rs.getString("g_format"),
						rs.getString("e_type"),
						rs.getString("just"),
						rs.getInt("r_amount"), 
						rs.getString("r_status")
						);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<ReimbursementForm> getAllReimbursementRequests() {
		List<ReimbursementForm> rForms = new ArrayList<>();
		String sql = "select * from ers.r_form";
		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				rForms.add(new ReimbursementForm(
						rs.getInt("e_id"),
						rs.getInt("r_id"),
						rs.getString("first_name"),
						rs.getString("last_name"),
						rs.getTimestamp("date_time"),
						rs.getString("loc"),
						rs.getString("description"),
						rs.getInt("r_cost"),
						rs.getString("g_format"),
						rs.getString("e_type"),
						rs.getString("just"),
						rs.getInt("r_amount"), 
						rs.getString("r_status")
						));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rForms;
	}
	
	public ReimbursementForm getSpecificReimbursementRequest(int rId) {
		String sql = "select * from ers.r_form where r_id = ?;";
		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, rId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return new ReimbursementForm(
						rs.getInt("e_id"),
						rs.getInt("r_id"),
						rs.getString("first_name"),
						rs.getString("last_name"),
						rs.getTimestamp("date_time"),
						rs.getString("loc"),
						rs.getString("description"),
						rs.getInt("r_cost"),
						rs.getString("g_format"),
						rs.getString("e_type"),
						rs.getString("just"),
						rs.getInt("r_amount"), 
						rs.getString("r_status")
						);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<ReimbursementForm> getAllRequestsFromSpecificEmployee(int eId) {
		List<ReimbursementForm> rForms = new ArrayList<>();
		String sql = "select * from ers.r_form where e_id = ?;";
		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, eId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				rForms.add(new ReimbursementForm(
						rs.getInt("e_id"),
						rs.getInt("r_id"),
						rs.getString("first_name"),
						rs.getString("last_name"),
						rs.getTimestamp("date_time"),
						rs.getString("loc"),
						rs.getString("description"),
						rs.getInt("r_cost"),
						rs.getString("g_format"),
						rs.getString("e_type"),
						rs.getString("just"),
						rs.getInt("r_amount"), 
						rs.getString("r_status")
						));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ReimbursementForm cancelReimbursementRequest(int rId) {
		String sql = "update ers.r_form set r_status = 'cancelled' where r_id = ? "
				+ "returning *";
		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, rId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return new ReimbursementForm(
						rs.getInt("e_id"),
						rs.getInt("r_id"),
						rs.getString("first_name"),
						rs.getString("last_name"),
						rs.getTimestamp("date_time"),
						rs.getString("loc"),
						rs.getString("description"),
						rs.getInt("r_cost"),
						rs.getString("g_format"),
						rs.getString("e_type"),
						rs.getString("just"),
						rs.getInt("r_amount"), 
						rs.getString("r_status")
						);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ReimbursementForm updateReimbursementStatus(String updateStatus, int rId) {
		String sql = "update ers.r_form set r_status = ? where r_id = ? "
				+ "returning *";
		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, updateStatus);
			ps.setInt(2, rId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return new ReimbursementForm(
						rs.getInt("e_id"),
						rs.getInt("r_id"),
						rs.getString("first_name"),
						rs.getString("last_name"),
						rs.getTimestamp("date_time"),
						rs.getString("loc"),
						rs.getString("description"),
						rs.getInt("r_cost"),
						rs.getString("g_format"),
						rs.getString("e_type"),
						rs.getString("just"),
						rs.getInt("r_amount"), 
						rs.getString("r_status")
						);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ReimbursementForm updateReimbursementAmount(int updateAmount, int rId) {
		String sql = "update ers.r_form set r_amount = ? where r_id = ? "
				+ "returning *";
		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, updateAmount);
			ps.setInt(2, rId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return new ReimbursementForm(
						rs.getInt("e_id"),
						rs.getInt("r_id"),
						rs.getString("first_name"),
						rs.getString("last_name"),
						rs.getTimestamp("date_time"),
						rs.getString("loc"),
						rs.getString("description"),
						rs.getInt("r_cost"),
						rs.getString("g_format"),
						rs.getString("e_type"),
						rs.getString("just"),
						rs.getInt("r_amount"), 
						rs.getString("r_status")
						);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
