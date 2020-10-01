package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import model.Account;
import model.AccountStatus;
import model.AccountType;
import utilities.DAOUtilities;

public class AccountDAOImpl implements AccountDAO {
	Connection connection = null;
	PreparedStatement stmt = null;
	
	HashMap<Integer, String> typeMap = AccountTypeDAOImpl.getTypesMap();
	HashMap<Integer, String> roleMap = RolesDAOImpl.getRolesMap();
	HashMap<Integer, String> statusMap = AccountStatusDAOImpl.getStatusMap();
	
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
				
				AccountStatus status = new AccountStatus();
				int statusID = rs.getInt("status_id");
				status.setStatusId(statusID);
				status.setStatus(statusMap.get(statusID));
				account.setStatus(status);
				
				AccountType type = new AccountType();
				int typeID = rs.getInt("type_id");
				type.setTypeId(typeID);
				type.setType(typeMap.get(typeID));
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
			String sql = "insert into account values (?, ?, ?)";
			stmt = connection.prepareStatement(sql);
			
			stmt.setDouble(1, account.getBalance());
			stmt.setInt(2, account.getStatus().getStatusId());
			stmt.setInt(3, account.getType().getTypeId());
			
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
				
				AccountStatus status = new AccountStatus();
				int statusID = rs.getInt("status_id");
				status.setStatusId(statusID);
				status.setStatus(statusMap.get(statusID));
				account.setStatus(status);
				
				AccountType type = new AccountType();
				int typeID = rs.getInt("type_id");
				type.setTypeId(typeID);
				type.setType(typeMap.get(typeID));
				account.setType(type);
			}
			
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
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Account> getAccountsByUserAndType(int userID, String type) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean closeAccount() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean updateAccount(Account account) {
		// TODO Auto-generated method stub
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
