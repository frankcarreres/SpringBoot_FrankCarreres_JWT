package com.ieseljust.ad.DTO;

import java.util.Set;

import com.ieseljust.ad.model.Albums;
import com.ieseljust.ad.model.RecordCompany;
import com.ieseljust.ad.model.Singer;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

public class SingerDTO {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSingers;

    @Column
    private String name;
    
    @OneToMany(mappedBy = "theSinger", cascade = CascadeType.PERSIST)
    private Set<Albums> theAlbums;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "recordCompanyID", referencedColumnName = "idRC", unique = true)
    private RecordCompany rc;

	public int getIdSingers() {
		return idSingers;
	}

	public void setIdSingers(int idSingers) {
		this.idSingers = idSingers;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
    
    public Set<Albums> getTheAlbums() {
		return theAlbums;
	}

	public void setTheAlbums(Set<Albums> theAlbums) {
		this.theAlbums = theAlbums;
	}

	public RecordCompany getRc() {
		return rc;
	}

	public void setRc(RecordCompany rc) {
		this.rc = rc;
	}

	public static SingerDTO convertToDTO(Singer singer) {
    	SingerDTO singerDTO = new SingerDTO();
    	singerDTO.setIdSingers(singer.getIdSingers());
    	singerDTO.setName(singer.getName());
    	singerDTO.setRc(singer.getRc());
    	singerDTO.setTheAlbums(singer.getTheAlbums());
		return singerDTO;
    	
    }
    
    public static Singer convertToEntity(SingerDTO singerDTO) {
    	Singer singer = new Singer();
    	singer.setIdSingers(singerDTO.getIdSingers());
    	singer.setName(singerDTO.getName());
    	singer.setRc(singerDTO.getRc());
    	singer.setTheAlbums(singerDTO.getTheAlbums());
		return singer;
    	
    }

}
