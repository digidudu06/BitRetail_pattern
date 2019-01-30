package dao;

import java.util.List;

import domain.SuppolierDTO;

public class SupppolierDAOImpl implements SuppolierDAO {
	private static SupppolierDAOImpl instance = new SupppolierDAOImpl();
	public SupppolierDAOImpl() {}
	public static SupppolierDAOImpl getInstance() {return instance;}

	@Override
	public void insertSuppolier(SuppolierDTO sup) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<SuppolierDTO> selectSuppolierList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SuppolierDTO> selectSuppoliers(String supplierName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SuppolierDTO selectSuppolier(String supplierId) {
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
	public void updateSuppolier(SuppolierDTO sup) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deteleSuppolier(SuppolierDTO sup) {
		// TODO Auto-generated method stub
		
	}

}
