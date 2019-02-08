package dao;

import java.util.List;

import domain.CustomerDTO;

public interface CustomerDAO {
	public void insertCustomer(CustomerDTO cus);
	
	public List<CustomerDTO> selectCustomerLists();
	public List<CustomerDTO> selectCustomers(String City);
	public CustomerDTO selectCustomer(CustomerDTO cus);
	public int countCustomer();
	public boolean existsCustomerId(CustomerDTO cus);
	
	public void updateCustomer(CustomerDTO cus);
	
	public void deleteCustomer(CustomerDTO cus);
	
}
