package dev.joshua_coombs.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dev.joshua_coombs.models.*;
import dev.joshua_coombs.utils.ConnectionUtil;

public class AccountDAO {
	private static ConnectionUtil cu = ConnectionUtil.getConnectionUtil();
	private static ReimbursementFormDAO rfDao;
	
	public Account createAccount(Account a) {
		String sql = "insert into ers.accounts values (default, ?, ?, ?, ?, ?, ?) returning *;";
		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, a.getFirstName());
			ps.setString(2, a.getLastName());
			ps.setString(3, a.getUsername());
			ps.setString(4, a.getPassword());
			ps.setInt(5, a.getReimbursementAvailable());
			ps.setString(6, a.getAccessLevel());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return new Account(
						rs.getInt("id"),
						rs.getString("first_name"),
						rs.getString("last_name"),
						rs.getString("u_name"),
						rs.getString("p_word"),
						rs.getInt("r_available"),
						rs.getString("acc_level")
						);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Account getAccountByUsername(String username) {
		String sql = "select * from ers.accounts where u_name = ?;";
		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return new Account(
						rs.getInt("id"),
						rs.getString("first_name"),
						rs.getString("last_name"),
						rs.getString("u_name"),
						rs.getString("p_word"),
						rs.getInt("r_available"),
						rs.getString("acc_level")
						);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Account getSpecificAccountById(int id) {
		String sql = "select * from ers.accounts where id = ?;";
		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return new Account(
						rs.getInt("id"),
						rs.getString("first_name"),
						rs.getString("last_name"),
						rs.getString("u_name"),
						rs.getString("p_word"),
						rs.getInt("r_available"),
						rs.getString("acc_level")
						);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Account updateReimbursementAvailable(int id) {
		List<ReimbursementForm> rForms = rfDao.getAllRequestsFromSpecificEmployee(id);
		int sum = 0;
		for (int i = 0; i < rForms.size(); i++) {
			sum += rForms.get(i).getReimbursementAmount();
		}
		int newAmount;
		if (sum > AccountDAO.getSpecificAccountById(id).getReimbursementAvailable()) {
			newAmount = 0;
		} else {
			newAmount = AccountDAO.getSpecificAccountById(id).getReimbursementAvailable() - sum;
		}
		String sql = "update ers.accounts set r_available = ? where id = ? returning *;";
		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, newAmount);
			ps.setInt(2, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return new Account(
						rs.getInt("id"),
						rs.getString("first_name"),
						rs.getString("last_name"),
						rs.getString("u_name"),
						rs.getString("p_word"),
						rs.getInt("r_available"),
						rs.getString("acc_level")
						);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/*
	public Account changePassword(int id, String password) {
		String sql = "update ers.accounts set p_word = ? where id = ? returning *";
		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, password);
			ps.setInt(2, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return new Account(
						rs.getInt("id"),
						rs.getString("first_name"),
						rs.getString("last_name"),
						rs.getString("u_name"),
						rs.getString("p_word"),
						rs.getInt("r_available"),
						rs.getString("acc_level")
						);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	*/
}
