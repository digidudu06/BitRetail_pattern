package service;

import java.util.List;

import domain.OrderDTO;

public interface OrderService {
	public void registOrder(OrderDTO ord);
	
	public List<OrderDTO> bringEmplyoeeList();
	public List<OrderDTO> retrieveEmplyoees(String OrderDate);
	public OrderDTO retrieveEmployee(String OrderId);
	public int countEmployees();
	public boolean existsEmployee(String orderId);
	
	public void modifyEmployee(OrderDTO ord);
	
	public void removeEmployee(OrderDTO ord);
}
