package dao;

import java.util.List;

import domain.CustomerDTO;

public interface CustomerDAO {
	public void insertCustomer(CustomerDTO cus);
	
	public List<CustomerDTO> selectCustomerLists();
	public List<CustomerDTO> selectCustomers(String City);
	public CustomerDTO selectCustomer(String CustomerId);
	public int countCustomer();
	public boolean existsCustomer(String CustomerId);
	
	public void updateCustomer(CustomerDTO cus);
	
	public void deleteCustomer(CustomerDTO cus);
	
}
