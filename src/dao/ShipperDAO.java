package dao;

import java.util.List;

import domain.ShipperDTO;

public interface ShipperDAO {
	public void insertShipper(ShipperDTO shi);
	
	public List<ShipperDTO> selectShipperList();
	public List<ShipperDTO> selectShippers(String shipperName);
	public ShipperDTO selectShipper(String shipperId);
	public int countShipper();
	public boolean existsShipper(String shipperId);
	
	public void updateShipper(ShipperDTO shi);
	
	public void deteleShipper(ShipperDTO shi);

}
