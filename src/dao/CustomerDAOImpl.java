package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import domain.CustomerDTO;
import enums.CustomerSQL;
import enums.Vendor;
import factory.DatabaseFactory;

public class CustomerDAOImpl implements CustomerDAO{
	private static CustomerDAOImpl instance = new CustomerDAOImpl();
	public CustomerDAOImpl() {}
	public static CustomerDAOImpl getInstance() {return instance;}

	@Override
	public void insertCustomer(CustomerDTO cus) {
		System.out.println("커스터머 DAO임플:::::::::::::::::::");
		try {
			String sql = CustomerSQL.SIGNUP.toString();
			PreparedStatement pstmt = DatabaseFactory
					.creataDatabase(Vendor.ORACLE)
					.getConnection()
					.prepareStatement(sql);
			pstmt.setString(1, cus.getCustomerId());
			pstmt.setString(2, cus.getCustomerName());
			pstmt.setString(3, cus.getPassword());
			pstmt.setString(4, cus.getSsn());
			pstmt.setString(5, cus.getCity());
			pstmt.setString(6, cus.getPostalCode());
			pstmt.setString(7, cus.getAddress());
			int rs = pstmt.executeUpdate();
			System.out.println((rs==1)?"성공":"실패");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
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
