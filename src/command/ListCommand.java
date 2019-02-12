package command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.CustomerDTO;
import enums.Action;
import proxy.Proxy;
import service.CustomerServiceImpl;

//syso 가장 최근에 입력된 5명의 목록
public class ListCommand extends Command {

	public ListCommand(HttpServletRequest request, HttpServletResponse response) {
		super(request, response);
		switch (Action.valueOf(request.getParameter("cmd").toUpperCase())) {
		case CUST_LIST:
			System.out.println("List커맨드 내부1:::::::: "+request.getParameter("cmd"));
			System.out.println("List커맨드 내부1:::::::: "+request.getParameter("page"));
			System.out.println("List커맨드 내부2:::::::: "+request.getParameter("page_num"));
			System.out.println("List커맨드 내부3:::::::: "+request.getParameter("page_size"));
			List<CustomerDTO> list = CustomerServiceImpl
										.getInstance()
										.bringCustomerLists(new Proxy()
																.getPage());
			request.setAttribute("list", list);
			break;

		default:
			break;
		}
	}
	
}
