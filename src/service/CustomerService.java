package service;

import java.util.List;

import domain.CustomerDTO;
import proxy.Proxy;

public interface CustomerService {
	public void joinCustomer(CustomerDTO cus);
	
	public List<CustomerDTO> bringCustomerLists(Proxy pxy);
	public List<CustomerDTO> retrieveCustomers(Proxy pxy);
	public CustomerDTO retrieveCustomer(CustomerDTO cus);
	public int countCustomer(Proxy pxy);
	public boolean existsCustomerId(CustomerDTO cus);
	
	public void modifyCustomer(CustomerDTO cus);
	
	public void removeCustomer(CustomerDTO cus);
}
