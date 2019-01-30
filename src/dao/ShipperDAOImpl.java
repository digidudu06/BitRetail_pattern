package dao;

import java.util.List;

import domain.ShipperDTO;

public class ShipperDAOImpl implements ShipperDAO {
	private static ShipperDAOImpl instance = new ShipperDAOImpl();
	public ShipperDAOImpl() {}
	public static ShipperDAOImpl getInstance() {return instance;}


	@Override
	public void insertShipper(ShipperDTO shi) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ShipperDTO> selectShipperList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ShipperDTO> selectShippers(String shipperName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ShipperDTO selectShipper(String shipperId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countShipper() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean existsShipper(String shipperId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void updateShipper(ShipperDTO shi) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deteleShipper(ShipperDTO shi) {
		// TODO Auto-generated method stub
		
	}

}
