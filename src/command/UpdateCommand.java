package command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import domain.CustomerDTO;
import proxy.Proxy;
import proxy.RequestProxy;
import service.CustomerServiceImpl;

public class UpdateCommand extends Command {
	public UpdateCommand(Map<String, Proxy> pxy) {
		super(pxy);
		System.out.println("updateCommand!!!!!!!!!!!!!!");
		RequestProxy req = (RequestProxy)pxy.get("req");
		HttpServletRequest request = req.getRequest();
		
		/*CustomerDTO cus = new CustomerDTO();
		String customerId = request.getParameter("default_Id");
		String customerName = request.getParameter("default_Name");
		String password = (request.getParameter("password")==null)? "0000": request.getParameter("password");
		String phone = (request.getParameter("city")==null)? request.getParameter("default_city") : request.getParameter("city");
		String city = (request.getParameter("phone")==null)? request.getParameter("default_phone") : request.getParameter("phone");
		String address = (request.getParameter("address")==null)? request.getParameter("default_address") : request.getParameter("address");
		String postalCode = (request.getParameter("pastal_code")==null)? request.getParameter("default_postal_code") : request.getParameter("pastal_code");
		cus.setCity(city);
		cus.setPassword(password);
		cus.setPhone(phone);
		cus.setPostalCode(postalCode);
		cus.setAddress(address);
		cus.setCustomerName(customerName);
		cus.setCustomerId(customerId);*/
		
		
		/* 2번째 DB들렸다오기 */

		CustomerDTO cus = new CustomerDTO();
		cus.setCustomerId(request.getParameter("default_Id"));
		cus = CustomerServiceImpl.getInstance().retrieveOneCustomer(cus);
		System.out.println("@@@@수정 전 회원의 정보 : "+cus.toString());
		
		if(!request.getParameter("password").equals("")) {cus.setPassword(request.getParameter("password"));}
		if(!request.getParameter("city").equals("")) {cus.setCity(request.getParameter("city"));}
		if(!request.getParameter("phone").equals("")) {cus.setPhone(request.getParameter("phone"));}
		if(!request.getParameter("address").equals("")) {cus.setAddress(request.getParameter("address"));}
		if(!request.getParameter("postal_code").equals("")) {cus.setPostalCode(request.getParameter("postal_code"));}
		System.out.println("@@@@수정하려는 회원의 정보 : "+cus.toString());
		
		CustomerServiceImpl.getInstance().modifyCustomer(cus);

		request.setAttribute("cust", cus);
		
	}
}
