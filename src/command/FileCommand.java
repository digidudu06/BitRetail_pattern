package command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import domain.CustomerDTO;
import domain.ImageDTO;
import proxy.ImageProxy;
import proxy.Proxy;
import proxy.RequestProxy;
import service.CustomerServiceImpl;
import enums.Action;

public class FileCommand extends Command {

	public FileCommand(Map<String, Proxy> pxy) {
		super(pxy);
		RequestProxy req = (RequestProxy)pxy.get("req");
		HttpServletRequest request = req.getRequest();
		switch(Action.valueOf(request.getParameter("cmd").toUpperCase())) {
		case CUST_FILE_UPLOAD:
			System.out.println("+++++++파일 커맨드+++++++"); 
			ImageProxy imageProxy = new ImageProxy();
			imageProxy.carryOut(request);
			ImageDTO image = imageProxy.getImg();
			String customerId = imageProxy.getImg().getOwner();
			CustomerDTO cus = new CustomerDTO();
			cus.setCustomerId(customerId);
			imageProxy.getImg().setOwner(request.getParameter("customer_id"));
			cus = CustomerServiceImpl.getInstance().retrieveOneCustomer(cus);
			request.setAttribute("image", image);
			request.setAttribute("cust", cus);
			break;
		default:
			break;
		}
	}

}
