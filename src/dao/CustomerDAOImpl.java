package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.CustomerDTO;
import enums.Action;
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
			String sql = CustomerSQL.SIGNIN.toString();
			PreparedStatement pstmt = DatabaseFactory
					.creataDatabase(Vendor.ORACLE)
					.getConnection()
					.prepareStatement(sql);
			pstmt.setString(1, cus.getCustomerId());
			pstmt.setString(2, cus.getPassword());
		
			ResultSet rs = pstmt.executeQuery();
			
			
			while(rs.next()) {
				customer= new CustomerDTO();
				customer.setAddress(rs.getString("ADDRESS"));
				customer.setCity(rs.getString("CITY"));
				customer.setCustomerId(rs.getString("CUSTOMER_ID"));
				customer.setCustomerName(rs.getString("CUSTOMER_NAME"));
				customer.setPassword(rs.getString("PASSWORD"));
				customer.setPostalCode(rs.getString("POSTAL_CODE"));
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
			String sql = CustomerSQL.CUST_UPDATE.toString();
			PreparedStatement pstmt = DatabaseFactory
					.creataDatabase(Vendor.ORACLE)
					.getConnection()
					.prepareStatement(sql);
			pstmt.setString(1, cus.getPassword());
			pstmt.setString(2, cus.getAddress());
			pstmt.setString(3, cus.getCity());
			pstmt.setString(4, cus.getPostalCode());
			pstmt.setString(5, cus.getPhone());
			pstmt.setString(6, cus.getCustomerId());
			int rs = pstmt.executeUpdate();
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
	
	@Override
	public Map<String, Object> selectPhone(Proxy pxy) {
		Map<String, Object> map = new HashMap<String, Object>();
		CustomerDTO customer = null;
		try {
			String sql = CustomerSQL.CUS_PHONE.toString();
			PreparedStatement ps = DatabaseFactory
			.creataDatabase(Vendor.ORACLE)
			.getConnection()
			.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				customer = new CustomerDTO();
				customer.setCustomerId(rs.getString("CUSTOMER_ID"));
				customer.setCustomerName(rs.getString("CUSTOMER_NAME"));
				customer.setPhone(rs.getString("PHONE"));
				map.put(rs.getString("CUSTOMER_ID"), customer);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	@Override
	public CustomerDTO selectOneCustomer(CustomerDTO cus) {
		CustomerDTO customer = new CustomerDTO();
		try {
			String sql = CustomerSQL.CUST_RETRIEVE.toString();
			PreparedStatement pstmt = DatabaseFactory
					.creataDatabase(Vendor.ORACLE)
					.getConnection()
					.prepareStatement(sql);
			pstmt.setString(1, cus.getCustomerId());
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				customer.setAddress(rs.getString("ADDRESS"));
				customer.setCity(rs.getString("CITY"));
				customer.setCustomerId(rs.getString("CUSTOMER_ID"));
				customer.setCustomerName(rs.getString("CUSTOMER_NAME"));
				customer.setPhone(rs.getString("PHONE"));
				customer.setPostalCode(rs.getString("POSTAL_CODE"));
				customer.setSsn(rs.getString("SSN"));
				customer.setPassword(rs.getString("PASSWORD"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customer;
	}
	

}
