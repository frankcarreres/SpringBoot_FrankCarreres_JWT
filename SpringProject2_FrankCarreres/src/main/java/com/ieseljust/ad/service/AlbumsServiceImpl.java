package com.ieseljust.ad.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.ieseljust.ad.DTO.AlbumsDTO;
import com.ieseljust.ad.model.Albums;
import com.ieseljust.ad.repository.AlbumsRepository;

public class AlbumsServiceImpl implements AlbumsService {
	
	@Autowired
	private AlbumsRepository albumsR;

	@Override
	public AlbumsDTO saveAlbum(AlbumsDTO albumDTO) {
		Albums albums = AlbumsDTO.convertToEntity(albumDTO);
		albumsR.save(albums);
		return albumDTO;
	}

	@Override
	public AlbumsDTO getAlbumById(int id) {
		Optional<Albums>albums = albumsR.findById(id);
		if(albums.isPresent()) {
			return AlbumsDTO.convertToDTO(albums.get());
		}else {
			return null;
		}
	}

	@Override
	public List<AlbumsDTO> listAllAlbums() {
		List<Albums> llista = albumsR.findAll();
		List<AlbumsDTO> llistaResultat = new ArrayList<AlbumsDTO>();
		for(int i = 0; i < llista.size(); ++i) {
			llistaResultat.add(AlbumsDTO.convertToDTO(llista.get(i)));
		}
		return null;
	}

	@Override
	public void deleteAlbums(int id) {
		albumsR.deleteById(id);
	}

}
