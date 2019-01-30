package dao;

import java.util.List;

import domain.CustomerDTO;

public class CustomerDAOImple implements CustomerDAO{
	private static CustomerDAOImple instance = new CustomerDAOImple();
	public CustomerDAOImple() {}
	public static CustomerDAOImple getInstance() {return instance;}


	@Override
	public void insertCustomer(CustomerDTO cus) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CustomerDTO> selectCustomerLists() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CustomerDTO> selectCustomers(String City) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerDTO selectCustomer(String CustomerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countCustomer() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean existsCustomer(String CustomerId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void updateCustomer(CustomerDTO cus) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCustomer(CustomerDTO cus) {
		// TODO Auto-generated method stub
		
	}
	

}
