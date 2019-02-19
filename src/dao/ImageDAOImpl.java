package dao;

import java.sql.Connection;
import java.util.List;

import domain.ImageDTO;
import enums.Vendor;
import factory.DatabaseFactory;
import proxy.Proxy;

public class ImageDAOImpl implements ImageDAO {
	private static ImageDAOImpl instance = new ImageDAOImpl();
	Connection conn;
	public ImageDAOImpl() {
		conn = DatabaseFactory
				.creataDatabase(Vendor.ORACLE)
				.getConnection();
	}
	public static ImageDAOImpl getInstance() {return instance;}

	@Override
	public void insertImage(ImageDTO img) {
		
	}

	@Override
	public List<ImageDTO> selectImageList(Proxy pxy) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ImageDTO> selectImages(Proxy pxy) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ImageDTO selectOneImage(ImageDTO img) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countImages(Proxy pxy) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean existImage(ImageDTO img) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void updateImage(ImageDTO img) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteImage(ImageDTO img) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String lastImageSeq() {
		// TODO Auto-generated method stub
		return null;
	}

}
