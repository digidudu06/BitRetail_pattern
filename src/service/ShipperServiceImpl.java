package service;

import java.util.List;

import domain.ShipperDTO;

public class ShipperServiceImpl implements ShipperService {
	private static ShipperServiceImpl intance = new ShipperServiceImpl();
	public ShipperServiceImpl() {}
	public static ShipperServiceImpl getIntance() {return intance;}


	public static void setIntance(ShipperServiceImpl intance) {
		ShipperServiceImpl.intance = intance;
	}


	@Override
	public void joinShipper(ShipperDTO shi) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ShipperDTO> bringShipperList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ShipperDTO> retrieveShippers(String shipperName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ShipperDTO retrieveShipper(String shipperId) {
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
	public void modifyShipper(ShipperDTO shi) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeShipper(ShipperDTO shi) {
		// TODO Auto-generated method stub
		
	}

}
