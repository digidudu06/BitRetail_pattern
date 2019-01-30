package service;

import java.util.List;

import domain.CustomerDTO;
import domain.EmployeeDTO;

public interface CustomerService {
	public void joinCustomer(CustomerDTO cus);
	
	public List<CustomerDTO> bringCustomerLists();
	public List<CustomerDTO> retrieveCustomers(String City);
	public CustomerDTO retrieveCustomer(String CustomerId);
	public int countCustomer();
	public boolean existsCustomer(String CustomerId);
	
	public void modifyCustomer(CustomerDTO cus);
	
	public void removeCustomer(CustomerDTO cus);
}
