package command;

import java.util.HashMap;
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
			System.out.println(imageProxy.getImg());
			imageProxy.carryOut(request);
			ImageDTO image = imageProxy.getImg();
			String customerId = imageProxy.getImg().getOwner();
//			CustomerServiceImpl.getInstance().fileUpload(imageProxy);
			
			Map<String, Object> map = new HashMap<>();
			map =CustomerServiceImpl
					.getInstance()
					.fileUpload(imageProxy);
			request.setAttribute("image", map.get("image"));
			request.setAttribute("cust", map.get("cust"));
			break;
		default:
			break;
		}
	}

}
