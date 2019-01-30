package service;

import java.util.List;

import domain.ProductDTO;

public class ProductServiceImpl implements ProductService {
	private static ProductServiceImpl instance = new ProductServiceImpl();
	public ProductServiceImpl() {}
	public static ProductServiceImpl getInstance() {return instance;}

	@Override
	public void registProduct(ProductDTO pro) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ProductDTO> bringProductList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductDTO> retrieveProducts(String productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductDTO retrieveProduct(String productName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countProduct() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean existsProduct() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void modifyProduct(ProductDTO pro) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteProduct(ProductDTO pro) {
		// TODO Auto-generated method stub
		
	}

}
