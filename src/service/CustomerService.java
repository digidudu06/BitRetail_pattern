package service;

import java.util.List;

import domain.CustomerDTO;
import domain.EmployeeDTO;

public interface CustomerService {
	public void joinCustomer(CustomerDTO cus);
	
	public List<CustomerDTO> bringCustomerLists();
	public List<CustomerDTO> retrieveCustomers(String City);
	public CustomerDTO retrieveCustomer(CustomerDTO cus);
	public int countCustomer();
	public boolean existsCustomerId(CustomerDTO cus);
	
	public void modifyCustomer(CustomerDTO cus);
	
	public void removeCustomer(CustomerDTO cus);
}
