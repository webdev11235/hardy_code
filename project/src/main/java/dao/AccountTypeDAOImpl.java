package dao;

import java.util.HashMap;

public class AccountTypeDAOImpl implements AccountTypeDAO {
	public static HashMap<Integer, String> getTypesMap() {
		HashMap<Integer, String> typeMap = new HashMap<Integer, String>();
		typeMap.put(1, "Checking");
		typeMap.put(2, "Savings");
		
		return typeMap;
	}
}
