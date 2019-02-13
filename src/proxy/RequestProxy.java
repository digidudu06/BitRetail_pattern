package proxy;

import javax.servlet.http.HttpServletRequest;

import lombok.Data;

@Data
public class RequestProxy implements Proxy {
	private HttpServletRequest request;

	@Override
	public void carryOut(Object o) {
		System.out.println("--------3.RequestProxy---------");
		if((HttpServletRequest) o != null) {
			System.out.println("request o가 널X");
			setRequest((HttpServletRequest) o);
		}else {
			System.out.println("request o 가 널");
		}
	}
	
}
