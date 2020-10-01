package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.HashMap;

import model.Account;
import model.AccountStatus;

public class AccountStatusDAOImpl implements AccountStatusDAO {
	Connection connection = null;
	PreparedStatement stmt = null;
	
	


	public static AccountStatus getStatusObj(int statusID) {
		HashMap<Integer, String> statusMap = new HashMap<Integer, String>();
		statusMap.put(1, "Pending");
		statusMap.put(2, "Open");
		statusMap.put(3, "Closed");
		statusMap.put(4, "Denied");
		
		AccountStatus status = new AccountStatus();
		status.setStatusId(statusID);
		status.setStatus(statusMap.get(statusID));
		
		return status;
		
	}

}
