package command;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import enums.Action;
import proxy.PageProxy;
import proxy.Pagination;
import proxy.Proxy;
import proxy.RequestProxy;
import service.CategoryServiceImpl;
import service.CustomerServiceImpl;

//syso 가장 최근에 입력된 5명의 목록
public class ListCommand extends Command {

	public ListCommand(Map<String, Proxy> pxy) {
		super(pxy);
		RequestProxy req = (RequestProxy) pxy.get("req");
		HttpServletRequest request = req.getRequest();
		Proxy paging = new Pagination();
		paging.carryOut(request);
		Proxy pagePxy = new PageProxy();
		pagePxy.carryOut(paging);
		List<?> list = new ArrayList<>();
		
		switch (Action.valueOf(request.getParameter("cmd").toUpperCase())) {
		case CUST_LIST:
			System.out.println("List커맨드 내부1:::::::: "+request.getParameter("cmd"));
			System.out.println("List커맨드 내부1:::::::: "+request.getParameter("page"));
			System.out.println("List커맨드 내부2:::::::: "+request.getParameter("page_num"));
			System.out.println("List커맨드 내부3:::::::: "+request.getParameter("page_size"));
			
			list = CustomerServiceImpl
					.getInstance()
					.bringCustomerLists(pagePxy);
			break;
		case CATE_LIST:
			list = CategoryServiceImpl
					.getInstance()
					.bringCategoryLists(pagePxy);
			break;
		default:
			break;
		}
		request.setAttribute("list", list);
		request.setAttribute("pagination", paging);
	}
	
}
