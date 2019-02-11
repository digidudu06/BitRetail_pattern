package service;

import java.util.List;

import dao.CustomerDAO;
import dao.CustomerDAOImpl;
import domain.CustomerDTO;

public class CustomerServiceImpl implements CustomerService {
	private static CustomerServiceImpl instance = new CustomerServiceImpl();
	private CustomerServiceImpl() {dao = new CustomerDAOImpl().getInstance();}
	public static CustomerServiceImpl getInstance() {return instance;}
	private CustomerDAO dao;

	@Override
	public void joinCustomer(CustomerDTO cus) {
		dao.insertCustomer(cus);
	}

	@Override
	public List<CustomerDTO> bringCustomerLists() {
		return dao.selectCustomerLists();
	}

	@Override
	public List<CustomerDTO> retrieveCustomers(String City) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerDTO retrieveCustomer(CustomerDTO cus) {
		return dao.selectCustomer(cus);
	}

	@Override
	public int countCustomer() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean existsCustomerId(CustomerDTO cus) {		
		return dao.existsCustomerId(cus);
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
