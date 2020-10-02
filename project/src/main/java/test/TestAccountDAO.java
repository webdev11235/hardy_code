package test;

import dao.AccountDAOImpl;
import dao.AccountStatusDAOImpl;
import dao.AccountTypeDAOImpl;
import model.Account;
import model.AccountStatus;
import model.AccountType;

public class TestAccountDAO {
	public static AccountDAOImpl dao = new AccountDAOImpl();
	public static void main(String[] args) {
		
		//test getAllAccounts()
		for (Account acct: dao.getAllAccounts()) {
			System.out.println(acct);
		}
		
/************************************************************************************************************/
		
		System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");
		
		//test createAccount()
				//a user must be created before account and then it user_account entry must be created realistically
				//I can created an account without a user right now
				//should I be able to create an account if it already exist? no
				/*Account account = new Account();
				account.setBalance(30);
				AccountStatus status = AccountStatusDAOImpl.getStatusObj(2);
				AccountType type = AccountTypeDAOImpl.getAccountTypeObj(1);
				account.setStatus(status);
				account.setType(type);
				dao.createAccount(account);
		
		for (Account acct: dao.getAllAccounts()) {
			System.out.println(acct);
		}*/
		
/************************************************************************************************************/
		
		System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");

		//test getAccountByAccountID()
		
		/*System.out.println(dao.getAccountByAccountID(10));*/
		
/************************************************************************************************************/
		
		System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");

		//test getAccountsByStatusID()
		//getAccountsByID had status field set to type
		
		for (Account acct: dao.getAccountsByStatusID(1)) {
			System.out.println(acct);
		}
		
/************************************************************************************************************/
		
		System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");

		//test getAccountsByUserAndType for my user_accounts table I need to make sure that if the user_id
		//account_id pair already exist than do not update it!!!
		//user_accounts table must be updated by grabbing user_id and account_id directly from the tables
		//if user or account is deleted then user_accounts table must be updated to reflect that!!!
		//this function will not work if it is not kept updated!!! it did not work for account_id = 10!!!
		for (Account acct: dao.getAccountsByUserAndType(1, "Savings")) {
			System.out.println(acct);
		}
		
/************************************************************************************************************/
		
		System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");

		//test closeAccount();
		Account tobeClose = dao.getAccountByAccountID(10);
		dao.closeAccount(tobeClose);
		
		System.out.println(dao.getAccountByAccountID(10));
		
/************************************************************************************************************/
		
		System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");
		
		//testing updateAccount();
		
		Account toBeOpenChecking = dao.getAccountByAccountID(10);
		AccountStatus openStatus = AccountStatusDAOImpl.getStatusObj(2);
		AccountType turnToChecking = AccountTypeDAOImpl.getAccountTypeObj(1);
		toBeOpenChecking.setStatus(openStatus);
		toBeOpenChecking.setType(turnToChecking);
		dao.updateAccount(toBeOpenChecking);
		
		System.out.println(dao.getAccountByAccountID(10));
		

		
	}
}


