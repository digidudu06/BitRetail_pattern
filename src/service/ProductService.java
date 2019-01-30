package service;

import java.util.List;

import domain.ProductDTO;

public interface ProductService {
	public void registProduct(ProductDTO pro);
	
	public List<ProductDTO> bringProductList();
	public List<ProductDTO> retrieveProducts(String productId);
	public ProductDTO retrieveProduct(String productName);
	public int countProduct();
	public boolean existsProduct();
	
	public void modifyProduct(ProductDTO pro);
	
	public void deleteProduct(ProductDTO pro);
}
