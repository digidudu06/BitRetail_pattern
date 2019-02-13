package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import domain.CustomerDTO;
import enums.CustomerSQL;
import enums.Vendor;
import factory.DatabaseFactory;
import proxy.PageProxy;
import proxy.Pagination;
import proxy.Proxy;

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
			pstmt.setString(5, cus.getPhone());
			pstmt.setString(6, cus.getCity());
			pstmt.setString(7, cus.getPostalCode());
			pstmt.setString(8, cus.getAddress());
			int rs = pstmt.executeUpdate();
			System.out.println((rs==1)?"성공":"실패");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<CustomerDTO> selectCustomerLists(Proxy pxy) {
		List<CustomerDTO> list = new ArrayList<>();
		try {
			Pagination page = ((PageProxy)pxy).getPage();
			PreparedStatement pstmt = DatabaseFactory
			.creataDatabase(Vendor.ORACLE)
			.getConnection()
			.prepareStatement(CustomerSQL.LIST.toString());
			String startRow = page.getStartRow()+"";
			String endRow = page.getEndRow()+"";
			System.out.println("DAO 스타트로우"+startRow);
			System.out.println("DAO end"+endRow);
			pstmt.setString(1, page.getStartRow()+"");
			pstmt.setString(2, page.getEndRow()+"");
			ResultSet rs = pstmt.executeQuery();
			CustomerDTO cust = null;
			while(rs.next()) {
				cust = new CustomerDTO();
				cust.setCustomerId(rs.getString("CUSTOMER_ID"));
                cust.setCustomerName(rs.getString("CUSTOMER_NAME"));
                cust.setSsn(rs.getString("SSN"));
                cust.setPhone(rs.getString("PHONE"));
                cust.setCity(rs.getString("CITY"));
                cust.setAddress(rs.getString("ADDRESS"));
                cust.setPostalCode(rs.getString("POSTAL_CODE"));
                cust.setRnum(rs.getString("RNUM"));
				list.add(cust);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<CustomerDTO> selectCustomers(Proxy pxy) {
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
	public CustomerDTO selectCustomer(CustomerDTO cus) {
		CustomerDTO customer = null;
		try {
			PreparedStatement pstmt = DatabaseFactory
			.creataDatabase(Vendor.ORACLE)
			.getConnection()
			.prepareStatement(CustomerSQL.SIGNIN.toString());
			pstmt.setString(1, cus.getCustomerId());
			pstmt.setString(2, cus.getPassword());
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				customer= new CustomerDTO();
				customer.setAddress(rs.getString("ADDRESS"));
				customer.setCity(rs.getString("CITY"));
				customer.setCustomerId(rs.getString("CUSTOMERID"));
				customer.setCustomerName(rs.getString("CUSTOMERID"));
				customer.setPassword(rs.getString("PASSWORD"));
				customer.setPostalCode(rs.getString("POSTALCODE"));
				customer.setSsn(rs.getString("SSN"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customer;
	}

	@Override
	public int countCustomer(Proxy pxy) {
		int count = 0;
		try {
			String sql = CustomerSQL.ROW_COUNT.toString();
			PreparedStatement pstmt = DatabaseFactory
			.creataDatabase(Vendor.ORACLE)
			.getConnection()
			.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				count=rs.getInt("COUNT");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public boolean existsCustomerId(CustomerDTO cus) {
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
