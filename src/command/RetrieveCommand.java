package command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import domain.CustomerDTO;
import proxy.Proxy;
import proxy.RequestProxy;
import service.CustomerServiceImpl;

public class RetrieveCommand extends Command {
	public RetrieveCommand(Map<String, Proxy> pxy) {
		super(pxy);
		RequestProxy req = (RequestProxy)pxy.get("req");
		HttpServletRequest request = req.getRequest();
		CustomerDTO cus = new CustomerDTO();
		cus.setCustomerId(request.getParameter("customer_id"));
		cus = CustomerServiceImpl.getInstance().retrieveOneCustomer(cus);
		request.setAttribute("cust", cus);
	}

}
