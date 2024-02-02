package com.ieseljust.ad.DTO;

import com.ieseljust.ad.model.Albums;
import com.ieseljust.ad.model.Singer;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class AlbumsDTO {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAlbums;

    @Column
    private String title;
    
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "singerID")
    private Singer theSinger;


	public Singer getTheSinger() {
		return theSinger;
	}

	public void setTheSinger(Singer theSinger) {
		this.theSinger = theSinger;
	}

	public int getIdAlbums() {
		return idAlbums;
	}

	public void setIdAlbums(int idAlbums) {
		this.idAlbums = idAlbums;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
    
    public static AlbumsDTO convertToDTO(Albums albums) {
    	AlbumsDTO albumsDTO = new AlbumsDTO();
    	albumsDTO.setIdAlbums(albums.getIdAlbums());
    	albumsDTO.setTitle(albums.getTitle());
    	albumsDTO.setTheSinger(albums.getTheSinger());
		return albumsDTO;   	
    }
    
    public static Albums convertToEntity(AlbumsDTO albumsDTO) {
    	Albums albums = new Albums();
    	albums.setIdAlbums(albumsDTO.getIdAlbums());
    	albums.setTitle(albumsDTO.getTitle());
    	albums.setTheSinger(albums.getTheSinger());
		return albums;	
    }
    
}
