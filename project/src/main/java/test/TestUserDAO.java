package test;

import dao.RolesDAOImpl;
import dao.UserDAOImpl;
import model.Role;
import model.User;

public class TestUserDAO {
	public static UserDAOImpl dao = new UserDAOImpl();
	public static void main(String[] args) {
		
		//test getAllCustomers()
		
		for (User usr:dao.getAllCustomers()) {
			System.out.println(usr);
		}
		
/************************************************************************************************************/
		
		System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");

		//test getCustomerByUsername()
		
		System.out.println(dao.getCustomerByUsername("sherri"));
		
/************************************************************************************************************/
		
		System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");

		//test getCustomerByID()
		
		System.out.println(dao.getCustomerByID(3));
		
/************************************************************************************************************/
		
		System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");

		//test createCustomerProfile()
		
		/*User usr = new User();
		usr.setUsername("king james");
		usr.setPassword("password5");
		usr.setFirstName("lebron");
		usr.setLastName("james");
		usr.setEmail("lebron@lakers.com");
		usr.setRole(RolesDAOImpl.getRolesObj(3));
		
		dao.createCustomerProfile(usr);
		
		System.out.println(dao.getCustomerByUsername("king james"));*/
		
/************************************************************************************************************/
		
		System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");

		//test updateCustomerProfle();
		User updateUsr = dao.getCustomerByID(6);
		Role role = RolesDAOImpl.getRolesObj(4);
		updateUsr.setRole(role);
		updateUsr.setEmail("kingJames@lakers.com");
		dao.updateCustomerProfile(updateUsr);
		System.out.println(dao.getCustomerByID(6));
		
/************************************************************************************************************/
		
		System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");
		
		//test deleteCustomer();
		//need to make sure if I delete a customer the account is gone first and the user_account is updated or for close account just change status don't delete anything!!!
		//keep account in table?

	}
}
