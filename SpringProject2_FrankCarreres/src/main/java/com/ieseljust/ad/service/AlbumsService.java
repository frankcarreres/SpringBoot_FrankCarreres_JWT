package com.ieseljust.ad.service;

import java.util.List;
import com.ieseljust.ad.DTO.AlbumsDTO;

public interface AlbumsService {
	
	AlbumsDTO saveAlbum(AlbumsDTO albumDTO);
	AlbumsDTO getAlbumById(int id);
	List<AlbumsDTO>listAllAlbums();
	void deleteAlbums(int id);
	

}
