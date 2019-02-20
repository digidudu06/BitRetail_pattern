package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import domain.ImageDTO;
import enums.ImageSQL;
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
		try {
			PreparedStatement ps= conn.prepareStatement(ImageSQL.IMG_STORE.toString());
			ps.setString(1, img.getImgName());
			ps.setString(2, img.getImgExtention());
			ps.setString(3, img.getOwner());
			int rs = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
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
		ImageDTO image = new ImageDTO();
		try {
			String sql = "SELECT * FROM IMAGES\n" + 
							"WHERE IMG_SEQ LIKE ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, img.getImgSeq());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				image.setImgExtention(rs.getString("IMG_EXTENTION"));
				image.setImgName(rs.getString("IMG_NAME"));
				image.setImgSeq(rs.getString("IMG_SEQ"));
				image.setOwner(rs.getString("OWNER"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return image;
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
	public String lastImageSeq(ImageDTO img) {
		String res = "";
		try {
			String sql = "SELECT MAX(IMG_SEQ) SEQ \n" + 
					"FROM IMAGES \n" + 
					"WHERE OWNER LIKE ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, img.getOwner());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				res = rs.getString("SEQ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

}
