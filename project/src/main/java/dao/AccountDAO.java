package dao;

import java.util.List;

import model.Account;

public interface AccountDAO {
	public List<Account> getAllAccounts();
	public boolean createAccount(Account account);
	public Account getAccountByAccountID(int accountID);
	public List<Account> getAccountsByStatusID(int statusID);
	public List<Account> getAccountsByUserAndType(int userID, String type);
	public boolean closeAccount(Account account);
	public boolean updateAccount(Account account);
}
