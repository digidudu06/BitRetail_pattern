package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.EmployeeDTO;
import service.EmployeeServiceImpl;

public class CreateCommand extends Command {
	public CreateCommand(HttpServletRequest request, HttpServletResponse response) {
		super(request, response);
		EmployeeDTO emp = new EmployeeDTO();
		emp.setBirthDate(request.getParameter("birthday"));
		emp.setManager(request.getParameter("manager"));
		emp.setName(request.getParameter("name"));
		emp.setNotes(request.getParameter("desc"));
		emp.setPhoto(request.getParameter("photo"));
		EmployeeServiceImpl.getInstance().registEmployee(emp);
	}
}
