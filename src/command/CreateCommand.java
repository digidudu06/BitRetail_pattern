package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustomerDAO;
import domain.CustomerDTO;
import domain.EmployeeDTO;
import enums.Action;
import service.CustomerServiceImpl;
import service.EmployeeServiceImpl;

public class CreateCommand extends Command {
	public CreateCommand(HttpServletRequest request, HttpServletResponse response) {
		super(request, response);
		switch(Action.valueOf(request.getParameter("cmd").toUpperCase())) {
		case REGISTER: 
			EmployeeDTO emp = new EmployeeDTO();
			emp.setBirthDate(request.getParameter("birthday"));
			emp.setManager(request.getParameter("manager"));
			emp.setName(request.getParameter("name"));
			emp.setNotes(request.getParameter("desc"));
			emp.setPhoto(request.getParameter("photo"));
			EmployeeServiceImpl.getInstance().registEmployee(emp);
			break;
		case SIGNUP:
			CustomerDTO cus = new CustomerDTO();
			cus.setAddress(request.getParameter("address"));
			cus.setCity(request.getParameter("city"));
			cus.setCustomerId(request.getParameter("customerId"));
			cus.setCustomerName(request.getParameter("customerName"));
			cus.setPassword(request.getParameter("password"));
			cus.setPostalCode(request.getParameter("postalCode"));
			cus.setSsn(request.getParameter("ssn"));
			CustomerServiceImpl.getInstance().joinCustomer(cus);
			break;
		default:
			break;
		}
	}
}
