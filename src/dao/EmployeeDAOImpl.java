package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.EmployeeDTO;
import enums.EmployeeSQL;
import enums.Vendor;
import factory.DatabaseFactory;

public class EmployeeDAOImpl implements EmployeeDAO {
	private static EmployeeDAOImpl instance = new EmployeeDAOImpl();
	public EmployeeDAOImpl() {
		pstmt = null;
	}
	public static EmployeeDAOImpl getInstance() {return instance;}
	PreparedStatement pstmt;
	
	@Override
	public void insertEmployee(EmployeeDTO emp) {
		try {
			/* 입력 순서 MANAGER,NAME,BIRTH_DATE,PHOTO,NOTES*/
			String sql = EmployeeSQL.REGISTER.toString();
			System.out.println("실행할 쿼리 ::"+sql);
			pstmt = DatabaseFactory
					.creataDatabase(Vendor.ORACLE)
					.getConnection()
					.prepareStatement(sql);
			pstmt.setString(1, emp.getManager());
			pstmt.setString(2, emp.getName());
			pstmt.setString(3, emp.getBirthDate());
			pstmt.setString(4, emp.getPhoto());
			pstmt.setString(5, emp.getNotes());
			int rs = pstmt.executeUpdate();
			System.out.println((rs==1)?"성공":"실패");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<EmployeeDTO> selectEmplyoeeList() {
		List<EmployeeDTO> list = new ArrayList<>();
		try {
			String sql = "";
			pstmt = DatabaseFactory
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
	public List<EmployeeDTO> selectEmplyoees(String searchWord) {
		List<EmployeeDTO> list = new ArrayList<>();
		try {
			String sql = "";
			pstmt = DatabaseFactory
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
	public EmployeeDTO selectEmployee(String searchWord) {
		EmployeeDTO emp = new EmployeeDTO();
		try {
			String sql = "";
			pstmt = DatabaseFactory
					.creataDatabase(Vendor.ORACLE)
					.getConnection()
					.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return emp;
	}

	@Override
	public int countEmployees() {
		int res = 0;
		try {
			String sql = "";
			pstmt = DatabaseFactory
			.creataDatabase(Vendor.ORACLE)
			.getConnection()
			.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public boolean existsEmployee(EmployeeDTO emp) {
		boolean ok = false;
		try {
			pstmt = DatabaseFactory
					.creataDatabase(Vendor.ORACLE)
					.getConnection()
					.prepareStatement(EmployeeSQL.ACCESS.toString());
			System.out.println("아이디 : "+emp.getEmploueeId()+" 이름 : "+emp.getName());
			pstmt.setString(1, emp.getEmploueeId());
			pstmt.setString(2, emp.getName());
			if(pstmt.executeQuery().next()) {ok = true;}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("접근허용 "+ok);
		return ok;
	}

	@Override
	public void updateEmployee(EmployeeDTO emp) {
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
	public void deleteEmployee(EmployeeDTO emp) {
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
