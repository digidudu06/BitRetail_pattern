package command;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import domain.CustomerDTO;
import domain.EmployeeDTO;
import enums.Action;
import proxy.PageProxy;
import proxy.Pagination;
import proxy.Proxy;
import proxy.RequestProxy;
import service.CustomerServiceImpl;
import service.EmployeeServiceImpl;

public class ExistCommand extends Command {
	public ExistCommand(Map<String, Proxy> pxy) {
		super(pxy);
		RequestProxy req = (RequestProxy) pxy.get("req");
		HttpServletRequest request = req.getRequest();
		HttpSession session = request.getSession();
		System.out.println("----- 6.익지스트 커맨드 접근--------");
		switch(Action.valueOf(request.getParameter("cmd").toUpperCase())) {
		case ACCESS:
			EmployeeDTO emp = new EmployeeDTO();
			emp.setEmploueeId(request.getParameter("empno"));
			emp.setName(request.getParameter("name"));
			boolean exist = EmployeeServiceImpl.getInstance().existsEmployee(emp);
			if(exist) {
				System.out.println("ACCESS접속성공");
				Proxy paging = new Pagination();
				paging.carryOut(request);
				Proxy pagePxy = new PageProxy();
				pagePxy.carryOut(paging);
				List<CustomerDTO> list = CustomerServiceImpl
						.getInstance()
						.bringCustomerLists(pagePxy);
				request.setAttribute("list", list);
				System.out.println("한 페이지 고객의 수 : "+list.size());
				//System.out.println("가장 최근에 가입한 고객명 : "+list.get(0).getCustomerName());
				request.setAttribute("pagination", paging);
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
