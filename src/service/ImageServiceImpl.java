package service;

import java.util.ArrayList;
import java.util.List;

import dao.ImageDAO;
import dao.ImageDAOImpl;
import domain.ImageDTO;
import proxy.Proxy;

public class ImageServiceImpl implements ImageService {
	private static ImageServiceImpl instantce = new ImageServiceImpl();
	public ImageServiceImpl() {dao = ImageDAOImpl.getInstance();}
	public static ImageServiceImpl getInstantce() {return instantce;}
	ImageDAO dao;

	@Override
	public void addImage(ImageDTO img) {
		dao.insertImage(img);
	}

	@Override
	public List<ImageDTO> imageList(Proxy pxy) {
		List<ImageDTO> list = new ArrayList<>();
		return list;
	}

	@Override
	public List<ImageDTO> searchImage(Proxy pxy) {
		List<ImageDTO> list = new ArrayList<>();
		return list;
	}

	@Override
	public ImageDTO oneImage(ImageDTO img) {
		ImageDTO image = new ImageDTO();
		return image;
	}

	@Override
	public int countImages(Proxy pxy) {
		int count = 0;
		return count;
	}

	@Override
	public boolean existImage(ImageDTO img) {
		boolean ok = false;
		return ok;
	}
	@Override
	public void modifyImage(ImageDTO img) {
		dao.updateImage(img);
	}
	@Override
	public void removeImage(ImageDTO img) {
		dao.deleteImage(img);
	}
	@Override
	public String lastImageSeq(ImageDTO img) {
		return dao.lastImageSeq(img);
	}

}
