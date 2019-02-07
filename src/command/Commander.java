package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import enums.Action;

public class Commander {
	public static Command order(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("-----3 커맨더 진입--------");
		Command cmd = null;
		System.out.println("커맨더 cmd ::"+request.getParameter("cmd"));
		switch(Action.valueOf(request.getParameter("cmd").toUpperCase())) {
		case MOVE:
			cmd = new Command(request, response);
			break;
		case REGISTER: case SIGNUP:
			cmd = new CreateCommand(request, response);			
			break;
		case ACCESS:
			cmd = new ExistCommand(request, response);			
			break;
		}
		System.out.println("커맨더 내부 : "+Receiver.cmd.getView());
		return cmd;
	}
	

}