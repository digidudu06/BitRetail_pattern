package proxy;

import javax.servlet.http.HttpServletResponse;

import lombok.Data;

@Data
public class ResponseProxy implements Proxy {
	private HttpServletResponse response;
	
	@Override
	public void carryOut(Object o) {
		System.out.println("-------4.responseProxy-------");
		if((HttpServletResponse) o != null) {
			System.out.println("response o가 널 X");
			setResponse((HttpServletResponse) o);
		}else {
			System.out.println("response o가 널");
		}
	}

}
