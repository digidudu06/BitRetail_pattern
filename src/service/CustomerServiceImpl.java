package service;

import java.util.List;

import domain.CustomerDTO;

public class CustomerServiceImpl implements CustomerService {
	private static CustomerServiceImpl instance = new CustomerServiceImpl();
	public CustomerServiceImpl() {}
	public static CustomerServiceImpl getInstance() {return instance;}


	@Override
	public void joinCustomer(CustomerDTO cus) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CustomerDTO> bringCustomerLists() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CustomerDTO> retrieveCustomers(String City) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerDTO retrieveCustomer(String CustomerId) {
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
	public void modifyCustomer(CustomerDTO cus) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeCustomer(CustomerDTO cus) {
		// TODO Auto-generated method stub
		
	}

}
