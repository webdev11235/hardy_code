package dao;

import java.util.HashMap;

import model.AccountType;

public class AccountTypeDAOImpl implements AccountTypeDAO {
	public static AccountType getAccountTypeObj(int typeID) {
		HashMap<Integer, String> typeMap = new HashMap<Integer, String>();
		typeMap.put(1, "Checking");
		typeMap.put(2, "Savings");
		
		AccountType type = new AccountType();
		type.setTypeId(typeID);
		type.setType(typeMap.get(typeID));
	
		return type;
	}
}
