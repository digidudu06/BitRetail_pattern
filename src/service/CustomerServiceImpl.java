package service;

import java.util.List;
import java.util.Map;

import dao.CustomerDAO;
import dao.CustomerDAOImpl;
import domain.CustomerDTO;
import proxy.Pagination;
import proxy.Proxy;

public class CustomerServiceImpl implements CustomerService {
	private static CustomerServiceImpl instance = new CustomerServiceImpl();
	private CustomerServiceImpl() {dao = CustomerDAOImpl.getInstance();}
	public static CustomerServiceImpl getInstance() {return instance;}
	CustomerDAO dao;

	@Override
	public void joinCustomer(CustomerDTO cus) {
		dao.insertCustomer(cus);
	}

	@Override
	public List<CustomerDTO> bringCustomerLists(Proxy pxy) {
		return dao.selectCustomerLists(pxy);
	}

	@Override
	public List<CustomerDTO> retrieveCustomers(Proxy pxy) {
		return dao.selectCustomers(pxy);
	}

	@Override
	public CustomerDTO retrieveCustomer(CustomerDTO cus) {
		return dao.selectCustomer(cus);
	}

	@Override
	public int countCustomer(Proxy pxy) {
		return dao.countCustomer(pxy);
	}

	@Override
	public boolean existsCustomerId(CustomerDTO cus) {		
		return dao.existsCustomerId(cus);
	}

	@Override
	public void modifyCustomer(CustomerDTO cus) {
		dao.updateCustomer(cus);
	}

	@Override
	public void removeCustomer(CustomerDTO cus) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Map<String, Object> retrievePhone(Proxy pxy) {
		return dao.selectPhone(pxy);
	}
	@Override
	public CustomerDTO retrieveOneCustomer(CustomerDTO cus) {
		return dao.selectOneCustomer(cus);
	}

}
