package service;

import java.util.List;

import dao.EmployeeDAO;
import dao.EmployeeDAOImpl;
import domain.EmployeeDTO;

public class EmployeeServiceImpl implements EmployeeService {
	private static EmployeeServiceImpl instance = new EmployeeServiceImpl();
	public EmployeeServiceImpl() {dao = new EmployeeDAOImpl().getInstance();}
	public static EmployeeServiceImpl getInstance() {return instance;}
	private EmployeeDAO dao;

	@Override
	public void registEmployee(EmployeeDTO emp) {
		dao.insertEmployee(emp);
	}

	@Override
	public List<EmployeeDTO> bringEmplyoeeList() {
		return dao.selectEmplyoeeList();
	}

	@Override
	public List<EmployeeDTO> retrieveEmplyoees(String searchWord) {
		return dao.selectEmplyoees(searchWord);
	}

	@Override
	public EmployeeDTO retrieveEmployee(String searchWord) {
		return dao.selectEmployee(searchWord);
	}

	@Override
	public int countEmployees() {
		return 0;
	}

	@Override
	public boolean existsEmployee(EmployeeDTO emp) {
		boolean ok = false;
		ok = dao.existsEmployee(emp);
		return ok;
	}

	@Override
	public void modifyEmployee(EmployeeDTO emp) {
		
	}

	@Override
	public void removeEmployee(EmployeeDTO emp) {
		
	}

}
