package dao;

import java.util.List;
import java.util.Map;

import domain.CustomerDTO;
import proxy.Proxy;

public interface CustomerDAO {
	public void insertCustomer(CustomerDTO cus);
	
	public List<CustomerDTO> selectCustomerLists(Proxy pxy);
	public List<CustomerDTO> selectCustomers(Proxy pxy);
	public CustomerDTO selectCustomer(CustomerDTO cus);
	public CustomerDTO selectOneCustomer(CustomerDTO cus);
	public Map<String, Object> selectPhone(Proxy pxy);
	public int countCustomer(Proxy pxy);
	public boolean existsCustomerId(CustomerDTO cus);
	
	public void updateCustomer(CustomerDTO cus);
	
	public void deleteCustomer(CustomerDTO cus);


	public CustomerDTO selectProfile(Proxy pxy);
	
}
