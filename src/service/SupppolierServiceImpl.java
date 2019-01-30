package service;

import java.util.List;

import domain.SuppolierDTO;

public class SupppolierServiceImpl implements SuppolierService {
	private static SupppolierServiceImpl instance = new SupppolierServiceImpl();
	public SupppolierServiceImpl() {}
	public static SupppolierServiceImpl getInstance() {return instance;}


	@Override
	public void registSuppolier(SuppolierDTO sup) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<SuppolierDTO> bringSuppolierList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SuppolierDTO> retrieveSuppoliers(String supplierName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SuppolierDTO retrieveSuppolier(String supplierId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countSuppolier() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean existsSuppolier() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void modifySuppolier(SuppolierDTO sup) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeSuppolier(SuppolierDTO sup) {
		// TODO Auto-generated method stub
		
	}

}
