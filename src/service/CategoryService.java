package service;

import java.util.List;

import domain.CategoryDTO;

public interface CategoryService {
	public void joinCategory(CategoryDTO cus);
	
	public List<CategoryDTO> bringCategoryLists();
	public List<CategoryDTO> retrieveCategorys(String city);
	public CategoryDTO retrieveCategory(String categoryId);
	public int countCategory();
	public boolean existsCategory(String categoryId);
	
	public void modifyCategory(CategoryDTO cus);
	
	public void removeCategory(CategoryDTO cus);
	
}
