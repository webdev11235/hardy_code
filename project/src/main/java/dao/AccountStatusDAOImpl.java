package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.HashMap;

public class AccountStatusDAOImpl implements AccountStatusDAO {
	Connection connection = null;
	PreparedStatement stmt = null;
	
	


	public static HashMap<Integer, String> getStatusMap() {
		HashMap<Integer, String> statusMap = new HashMap<Integer, String>();
		statusMap.put(1, "Pending");
		statusMap.put(2, "Open");
		statusMap.put(3, "Closed");
		statusMap.put(4, "Denied");
		return statusMap;
	}

}
