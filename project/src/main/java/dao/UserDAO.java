package dao;
import java.util.List;

import model.User;

public interface UserDAO {
	public List<User> getAllCustomers();
	public User viewCustomerByUsername(String username);
	public boolean createCustomerProfile();
	public boolean changeUsername();
	public boolean changePassword();
	public boolean changeFirstname();
	public boolean changeLastname();
	public boolean changeEmail();
	public boolean deleteCustomer();
	
	
}
