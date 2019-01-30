package service;

import java.util.List;

import domain.ShipperDTO;

public interface ShipperService {
	public void joinShipper(ShipperDTO shi);
	
	public List<ShipperDTO> bringShipperList();
	public List<ShipperDTO> retrieveShippers(String shipperName);
	public ShipperDTO retrieveShipper(String shipperId);
	public int countShipper();
	public boolean existsShipper(String shipperId);
	
	public void modifyShipper(ShipperDTO shi);
	
	public void removeShipper(ShipperDTO shi);
}
