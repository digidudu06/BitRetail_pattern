package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.CustomerDTO;
import domain.EmployeeDTO;
import enums.Action;
import service.CustomerServiceImpl;
import service.EmployeeServiceImpl;

public class ExistCommand extends Command {
	public ExistCommand(HttpServletRequest request, HttpServletResponse response) {
		super(request,response);
		System.out.println("----- 익지스트 커맨드 접근--------");
		switch(Action.valueOf(request.getParameter("cmd").toUpperCase())) {
		case ACCESS:
			EmployeeDTO emp = new EmployeeDTO();
			emp.setEmploueeId(request.getParameter("empno"));
			emp.setName(request.getParameter("name"));
			boolean exist = EmployeeServiceImpl.getInstance().existsEmployee(emp);
			if(exist) {
				System.out.println("ACCESS접속성공");
			}else {
				System.out.println("ACCESS접속실패");
				super.setDomain("home");
				super.setPage("main");
				super.execute();
			}
			break;
		case SIGNIN:
			CustomerDTO cus = new CustomerDTO();
			System.out.println(request.getParameter("customerId")+request.getParameter("password"));
			cus.setCustomerId(request.getParameter("customerId"));
			cus.setPassword(request.getParameter("password"));
			boolean exist1 = CustomerServiceImpl.getInstance().existsCustomer(cus);
			if(exist1) {
				System.out.println("SIGN접속성공");
			}else {
				System.out.println("SIGN접속실패");
				super.setDomain("home");
				super.setPage("main");
				super.execute();
			}
			break;
		default:
			break;
		}
		System.out.println("익지스트 커맨더 내부 : "+Receiver.cmd.getView());
	}
}
