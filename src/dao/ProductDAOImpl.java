package dao;

import java.util.List;

import domain.ProductDTO;

public class ProductDAOImpl implements ProductDAO {
	private static ProductDAOImpl instance = new ProductDAOImpl();
	public ProductDAOImpl() {}
	public static ProductDAOImpl getInstance() {return instance;}

	@Override
	public void insertProduct(ProductDTO pro) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ProductDTO> selectProductList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductDTO> selectProducts(String productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductDTO selectProduct(String productName) {
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
	public void updateProduct(ProductDTO pro) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteProduct(ProductDTO pro) {
		// TODO Auto-generated method stub
		
	}

}
