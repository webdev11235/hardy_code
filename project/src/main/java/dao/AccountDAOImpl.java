package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Account;
import model.AccountStatus;
import model.AccountType;
import utilities.DAOUtilities;

public class AccountDAOImpl implements AccountDAO {
	Connection connection = null;
	PreparedStatement stmt = null;
		
	@Override
	public List<Account> getAllAccounts() {
		List<Account> accounts = new ArrayList<Account>();
		
		try {
			connection = DAOUtilities.getConnection();
			String sql = "select * from account";
			stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Account account = new Account();
				account.setAccountId(rs.getInt("account_id"));
				account.setBalance(rs.getDouble("balance"));
				
				AccountStatus status = AccountStatusDAOImpl.getStatusObj(rs.getInt("status_id"));
				account.setStatus(status);
				
				AccountType type = AccountTypeDAOImpl.getAccountTypeObj(rs.getInt("type_id"));
				account.setType(type);
				
				accounts.add(account);
			}
			rs.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			closeResources();
			
		}
		return accounts;
	}
	
	
	@Override
	public boolean createAccount(Account account) {
		try {
			connection = DAOUtilities.getConnection();
			String sql = "insert into account (balance, status_id, type_id) values (?, ?, ?)";
			stmt = connection.prepareStatement(sql);
			
			stmt.setDouble(1, account.getBalance());
			stmt.setInt(2, account.getType().getTypeId());
			stmt.setInt(3, account.getStatus().getStatusId());
			
			
			if (stmt.executeUpdate() != 0) {
				return true;
			}
			else {
				return false;
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			closeResources();
		}
		return false;
	}
	@Override
	public Account getAccountByAccountID(int accountID) {
		Account account = null;
		try {
			connection = DAOUtilities.getConnection();
			String sql = "select * from account where account_id=?";
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, accountID);
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				account = new Account();
				account.setAccountId(rs.getInt("account_id"));
				account.setBalance(rs.getDouble("balance"));
				
				AccountStatus status = AccountStatusDAOImpl.getStatusObj(rs.getInt("status_id"));
				account.setStatus(status);
				
				AccountType type = AccountTypeDAOImpl.getAccountTypeObj(rs.getInt("type_id"));
				account.setType(type);
			}
			rs.close();
		}
		catch(SQLException e) {
			
		}
		finally {
			closeResources();
		}
		return account;
	}
	
	@Override
	public List<Account> getAccountsByStatusID(int statusID) {
		List<Account> accounts = new ArrayList<Account>();
		
		try {
			connection = DAOUtilities.getConnection();
			String sql = "select * from account where status_id=?";
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, statusID);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Account account = new Account();
				account.setAccountId(rs.getInt("account_id"));
				account.setBalance(rs.getDouble("balance"));
				
				AccountStatus status = AccountStatusDAOImpl.getStatusObj(rs.getInt("status_id"));
				account.setStatus(status);
				
				AccountType type = AccountTypeDAOImpl.getAccountTypeObj(rs.getInt("type_id"));
				account.setType(type);
				accounts.add(account);
			}
			rs.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			closeResources();
		}
		return accounts;
	}
	@Override
	public List<Account> getAccountsByUserAndType(int userID, String type) {
		List<Account> accounts = new ArrayList<Account>();
		try {
			connection = DAOUtilities.getConnection();
			String sql = "select account.* from user_account \r\n"
					+ "left join account on user_account.account_id = account.account_id \r\n"
					+ "left join users on user_account.user_id = users.user_id\r\n"
					+ "where users.user_id = ? and account.type_id = (select type_id from account_type where type=?);\r\n"
					+ "";
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, userID);
			stmt.setString(2, type);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Account account = new Account();
				account.setAccountId(rs.getInt("account_id"));
				account.setBalance(rs.getDouble("balance"));
				
				AccountStatus status = AccountStatusDAOImpl.getStatusObj(rs.getInt("status_id"));
				account.setStatus(status);
				
				AccountType accountType = AccountTypeDAOImpl.getAccountTypeObj(rs.getInt("type_id"));
				account.setType(accountType);
				accounts.add(account);
			}
			rs.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			closeResources();
		}
		return accounts;
	}
	@Override
	public boolean closeAccount(Account account) {
		try {
			connection = DAOUtilities.getConnection();
			String sql = "update account set status_id = (select status_id from account_status where status = 'Closed')\r\n"
					+ "where account_id= ?";
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, account.getAccountId());
			
			if (stmt.executeUpdate() != 0) {
				return true;
			}
			else {
				return false;
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			closeResources();
		}
		return false;
	}
	@Override
	public boolean updateAccount(Account account) {
		try {
			connection = DAOUtilities.getConnection();
			String sql = "update account set balance = ?, status_id = ?, type_id = ? where account_id = ?";
			stmt = connection.prepareStatement(sql);
			stmt.setDouble(1, account.getBalance());
			stmt.setInt(2, account.getStatus().getStatusId());
			stmt.setInt(3, account.getType().getTypeId());
			stmt.setInt(4, account.getAccountId());
			
			
			if (stmt.executeUpdate() != 0) {
				return true;
			}
			else {
				return false;
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
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
