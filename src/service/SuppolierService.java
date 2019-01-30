package service;

import java.util.List;

import domain.SuppolierDTO;

public interface SuppolierService {
	public void registSuppolier(SuppolierDTO sup);
	
	public List<SuppolierDTO> bringSuppolierList();
	public List<SuppolierDTO> retrieveSuppoliers(String supplierName);
	public SuppolierDTO retrieveSuppolier(String supplierId);
	public int countSuppolier();
	public boolean existsSuppolier();
	
	public void modifySuppolier(SuppolierDTO sup);
	
	public void removeSuppolier(SuppolierDTO sup);
}
