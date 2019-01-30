package dao;

import java.util.List;

import domain.EmployeeDTO;
import factory.DatabaseFactory;

public class EmployeeDAOImpl implements EmployeeDAO {
	private static EmployeeDAOImpl instance = new EmployeeDAOImpl();
	public EmployeeDAOImpl() {}
	public static EmployeeDAOImpl getInstance() {return instance;}

	@Override
	public void inserEmployee(EmployeeDTO emp) {
//		DatabaseFactory.createDatabase("oracle").getConnection().createStatement().executeUpdate();
		
	}

	@Override
	public List<EmployeeDTO> selectEmplyoeeList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployeeDTO> selectEmplyoees(String searchWord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmployeeDTO selectEmployee(String searchWord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countEmployees() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean existsEmployee(String searchWord) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void updateEmployee(EmployeeDTO emp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteEmployee(EmployeeDTO emp) {
		// TODO Auto-generated method stub
		
	}

}
