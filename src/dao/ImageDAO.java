package dao;

import java.util.List;

import domain.ImageDTO;
import proxy.Proxy;

public interface ImageDAO {
	public void insertImage(ImageDTO img);
	
	public List<ImageDTO> selectImageList(Proxy pxy);
	public List<ImageDTO> selectImages(Proxy pxy);
	public ImageDTO selectOneImage(ImageDTO img);
	public String lastImageSeq();
	
	public int countImages(Proxy pxy);
	public boolean existImage(ImageDTO img);
	
	public void updateImage(ImageDTO img);
	
	public void deleteImage(ImageDTO img);
}
