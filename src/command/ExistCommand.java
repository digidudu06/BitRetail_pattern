package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.EmployeeDTO;
import service.EmployeeServiceImpl;

public class ExistCommand extends Command {
	public ExistCommand(HttpServletRequest request, HttpServletResponse response) {
		super(request,response);
		System.out.println("----- 익지스트 커맨드 접근--------");
		EmployeeDTO emp = new EmployeeDTO();
		emp.setEmploueeId(request.getParameter("empno"));
		emp.setName(request.getParameter("name"));
		boolean exist = EmployeeServiceImpl.getInstance().existsEmployee(emp);
		if(exist) {
			System.out.println("성공");
		}else {
			System.out.println("실패");
			super.setDomain("home");
			super.setPage("main");
			super.execute();
		}
		System.out.println("익지스트 커맨더 내부 : "+Receiver.cmd.getView());
	}
}
