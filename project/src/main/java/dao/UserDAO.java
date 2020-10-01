package dao;
import java.util.List;

import model.User;

public interface UserDAO {
	public List<User> getAllCustomers();
	public User getCustomerByUsername(String username);
	public User getCustomerByID(int id);
	public boolean createCustomerProfile(User user);
	public boolean updateCustomerProfile(User user); 
	public boolean deleteCustomer(User user);
}
