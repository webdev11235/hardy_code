package dao;

import java.util.HashMap;

import model.Role;

public class RolesDAOImpl implements RoleDAO{
	public static Role getRolesMap(int roleID) {
		HashMap<Integer, String> roleMap = new HashMap<Integer, String>();
		roleMap.put(1, "Admin");
		roleMap.put(2, "Employee");
		roleMap.put(3, "Standard");
		roleMap.put(4, "Premium");
		
		Role role = new Role();
		role.setRoleId(roleID);
		role.setRole(roleMap.get(roleID));
		return role;
	}
}
