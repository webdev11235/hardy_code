package dao;

import model.Account;

public interface AccountDAO {
	public boolean createAccount();
	public Account viewAccount();
	public boolean closeAccount();
	public boolean updateAccount();
}
