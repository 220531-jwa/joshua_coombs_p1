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
	
	public Account createRF(Account a) {
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
}
