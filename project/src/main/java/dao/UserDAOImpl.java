package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Role;
import model.User;
import utilities.DAOUtilities;

public class UserDAOImpl implements UserDAO {
	Connection connection = null;
	PreparedStatement stmt = null;

	@Override
	public List<User> getAllCustomers() {
		List<User> users = new ArrayList<User>();
		
		try {
			connection = DAOUtilities.getConnection();
			String sql = "select * from users";
			stmt = connection.prepareStatement(sql);
			ResultSet rs =stmt.executeQuery();
			
			while (rs.next()) {
				User user = new User();
				
				user.setUserId(rs.getInt("user_id"));
				user.setFirstName(rs.getString("firstname"));
				user.setLastName(rs.getString("lastname"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				
				Role role = RolesDAOImpl.getRolesObj(rs.getInt("role_id"));
				user.setRole(role);
				
				users.add(user);
			}
			rs.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			closeResources();
		}
		return users;
	}

	@Override
	public User getCustomerByUsername(String username) {
		User user = null;
		try {
			connection = DAOUtilities.getConnection();
			String sql = "select * from users where username = ?";
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, username);
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				user = new User();
				user.setUserId(rs.getInt("user_id"));
				user.setFirstName(rs.getString("firstname"));
				user.setLastName(rs.getString("lastname"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				
				Role role = RolesDAOImpl.getRolesObj(rs.getInt("role_id"));
				user.setRole(role);
				
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeResources();
		}
		
		return user;
	}

	@Override
	public User getCustomerByID(int id) {
		User user = null;
		try {
			connection = DAOUtilities.getConnection();
			String sql = "select * from users where user_id = ?";
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				user = new User();
				user.setUserId(rs.getInt("user_id"));
				user.setFirstName(rs.getString("firstname"));
				user.setLastName(rs.getString("lastname"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				
				Role role = RolesDAOImpl.getRolesObj(rs.getInt("role_id"));
				user.setRole(role);
				
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeResources();
		}
		
		return user;
	}

	@Override
	public boolean createCustomerProfile(User user) {
		try {
			
			connection = DAOUtilities.getConnection();
			String sql = "insert into users (username, \"password\", firstname, lastname, email, role_id) values\r\n"
					+ "(?, ?, ?, ?, ?, ?)";
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, user.getUsername());
			stmt.setString(2, user.getPassword());
			stmt.setString(3, user.getFirstName());
			stmt.setString(4, user.getLastName());
			stmt.setString(5, user.getEmail());
			stmt.setInt(6, user.getRole().getRoleId());
			
			if (stmt.executeUpdate() != 0) {
				return true;
			}else {
				return false;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			closeResources();
		}
		return false;
	}

	@Override
	public boolean updateCustomerProfile(User user) {
		try {
			
			connection = DAOUtilities.getConnection();
			String sql = "update users set username=?, password=?, firstname=?, lastname=?, email=?, role_id=?\r\n"
					+ "where user_id = ?";
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, user.getUsername());
			stmt.setString(2, user.getPassword());
			stmt.setString(3, user.getFirstName());
			stmt.setString(4, user.getLastName());
			stmt.setString(5, user.getEmail());
			stmt.setInt(6, user.getRole().getRoleId());
			stmt.setInt(7, user.getUserId());
			
			if (stmt.executeUpdate() != 0) {
				return true;
			}else {
				return false;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			closeResources();
		}
		return false;
	}

	@Override
	public boolean deleteCustomer(User user) {
		try {
			
			connection = DAOUtilities.getConnection();
			String sql = "delete from users where user_id = ?";
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, user.getUserId());
			
			if (stmt.executeUpdate() != 0) {
				return true;
			}else {
				return false;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			closeResources();
		}
		return false;
	}
	
	private void closeResources() {
		try {
			if (stmt != null)
				stmt.close();
		} catch (SQLException e) {
			System.out.println("Could not close statement!");
			e.printStackTrace();
		}
		
		try {
			if (connection != null)
				connection.close();
		} catch (SQLException e) {
			System.out.println("Could not close connection!");
			e.printStackTrace();
		}
	
	}


}
