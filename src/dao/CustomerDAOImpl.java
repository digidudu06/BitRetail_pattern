package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.regexp.internal.recompile;

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
		List<CustomerDTO> list = new ArrayList<>();
		String sql = "";
		try {
			PreparedStatement pstmt = DatabaseFactory
			.creataDatabase(Vendor.ORACLE)
			.getConnection()
			.prepareStatement(sql);
			pstmt.setString(1, "");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(null);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<CustomerDTO> selectCustomers(String City) {
		List<CustomerDTO> list = new ArrayList<>();
		try {
			String sql = "";
			PreparedStatement pstmt = DatabaseFactory
			.creataDatabase(Vendor.ORACLE)
			.getConnection()
			.prepareStatement(sql);
			pstmt.setString(1, "");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(null);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public CustomerDTO selectCustomer(String CustomerId) {
		CustomerDTO cus = new CustomerDTO();
		try {
			String sql = "";
			PreparedStatement pstmt = DatabaseFactory
			.creataDatabase(Vendor.ORACLE)
			.getConnection()
			.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cus;
	}

	@Override
	public int countCustomer() {
		int count = 0;
		try {
			String sql = "";
			PreparedStatement pstmt = DatabaseFactory
			.creataDatabase(Vendor.ORACLE)
			.getConnection()
			.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public boolean existsCustomer(CustomerDTO cus) {
		boolean ok = false;
		try {
			String sql = CustomerSQL.SIGNIN.toString();
			PreparedStatement pstmt = DatabaseFactory
					.creataDatabase(Vendor.ORACLE)
					.getConnection()
					.prepareStatement(sql);
			pstmt.setString(1, cus.getCustomerId());
			pstmt.setString(2, cus.getPassword());
			if(pstmt.executeQuery().next()) {ok=true;}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("접근허용 "+ok);
		return ok;
	}

	@Override
	public void updateCustomer(CustomerDTO cus) {
		try {
			String sql = "";
			PreparedStatement pstmt = DatabaseFactory
			.creataDatabase(Vendor.ORACLE)
			.getConnection()
			.prepareStatement(sql);
			pstmt.setString(1, "");
			int rs = pstmt.executeUpdate();
			if(rs==1) {}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteCustomer(CustomerDTO cus) {
		try {
			String sql = "";
			PreparedStatement pstmt = DatabaseFactory
			.creataDatabase(Vendor.ORACLE)
			.getConnection()
			.prepareStatement(sql);
			pstmt.setString(1, "");
			int rs = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
