package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Carrier;
import command.Receiver;
import domain.EmployeeDTO;
import enums.Action;
import service.EmployeeService;
import service.EmployeeServiceImpl;

@WebServlet("/employee.do")
public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EmployeeService service = EmployeeServiceImpl.getInstance();
	EmployeeDTO emp = null;

	protected void service(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("----------1. 컨트롤러 진입-----------");
		Receiver.init(request, response);
		switch (Action.valueOf(Receiver.cmd.getAction().toUpperCase())) {
		case MOVE:
			System.out.println("무브 진입");
			Carrier.forward(request, response);
			break;
		case REGISTER:
			System.out.println("레지스터 진입");
			emp = new EmployeeDTO();
			emp.setBirthDate(request.getParameter("birthday"));
			emp.setManager(request.getParameter("manager"));
			emp.setName(request.getParameter("name"));
			emp.setNotes(request.getParameter("desc"));
			emp.setPhoto(request.getParameter("photo"));
			service.registEmployee(emp);
			Carrier.forward(request, response);
			break;
		}
	}
}