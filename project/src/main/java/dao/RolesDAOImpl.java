package dao;

import java.util.HashMap;

public class RolesDAOImpl implements RoleDAO{
	public static HashMap<Integer, String> getRolesMap() {
		HashMap<Integer, String> roleMap = new HashMap<Integer, String>();
		roleMap.put(1, "Admin");
		roleMap.put(2, "Employee");
		roleMap.put(3, "Standard");
		roleMap.put(4, "Premium");
		
		return roleMap;
	}
}
