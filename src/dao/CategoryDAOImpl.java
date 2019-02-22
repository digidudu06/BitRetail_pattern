package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import domain.CategoryDTO;
import enums.CategorySQL;
import enums.Vendor;
import factory.DatabaseFactory;
import proxy.PageProxy;
import proxy.Pagination;
import proxy.Proxy;

public class CategoryDAOImpl implements CategoryDAO {
	private static CategoryDAOImpl instance = new CategoryDAOImpl();
	public CategoryDAOImpl() {}
	public static CategoryDAO getInstance() {
		return new CategoryDAOImpl();
	}
	
	@Override
	public void insertCategory(CategoryDTO cus) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CategoryDTO> selectCategoryLists(Proxy pxy) {
		List<CategoryDTO> list = new ArrayList<>();
		try {
			Pagination page = ((PageProxy)pxy).getPage();
			PreparedStatement pstmt = DatabaseFactory
										.creataDatabase(Vendor.ORACLE)
										.getConnection()
										.prepareStatement(CategorySQL.CATE_LIST.toString());
			String startRow = page.getStartRow()+"";
			String endRow = page.getEndRow()+"";
			System.out.println("DAO 스타트로우"+startRow);
			System.out.println("DAO end"+endRow);
			pstmt.setString(1, page.getStartRow()+"");
			pstmt.setString(2, page.getEndRow()+"");
			ResultSet rs = pstmt.executeQuery();
			CategoryDTO cate = null;
			while(rs.next()) {
				cate = new CategoryDTO();
				cate.setCategoryId(rs.getString("CATEGORY_ID"));
				cate.setCategoryName(rs.getString("CATEGORY_NAME"));
				cate.setDescription(rs.getString("DESCRIPTION"));
				list.add(cate);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<CategoryDTO> selectCategorys(String city) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CategoryDTO selectCategory(String categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countCategory() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean existsCategory(String categoryId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void updateCategory(CategoryDTO cus) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCategory(CategoryDTO cus) {
		// TODO Auto-generated method stub
		
	}





}
