package command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.CustomerDTO;
import domain.EmployeeDTO;
import enums.Action;
import service.CustomerServiceImpl;
import service.EmployeeServiceImpl;

public class ExistCommand extends Command {
	public ExistCommand(HttpServletRequest request, HttpServletResponse response) {
		super(request,response);
		HttpSession session = request.getSession();
		System.out.println("----- 익지스트 커맨드 접근--------");
		switch(Action.valueOf(request.getParameter("cmd").toUpperCase())) {
		case ACCESS:
			EmployeeDTO emp = new EmployeeDTO();
			emp.setEmploueeId(request.getParameter("empno"));
			emp.setName(request.getParameter("name"));
			boolean exist = EmployeeServiceImpl.getInstance().existsEmployee(emp);
			if(exist) {
				System.out.println("ACCESS접속성공");
				List<CustomerDTO> list = CustomerServiceImpl
						.getInstance()
						.bringCustomerLists();
				request.setAttribute("list", list);
				System.out.println("총 고객의 수 : "+list.size());
				System.out.println("가장 최근에 가입한 고객명 : "+list.get(0).getCustomerName());
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
			cus = CustomerServiceImpl.getInstance().retrieveCustomer(cus);
			if(cus != null) {
				System.out.println("SIGN접속성공");
				session.setAttribute("customer", cus);
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
