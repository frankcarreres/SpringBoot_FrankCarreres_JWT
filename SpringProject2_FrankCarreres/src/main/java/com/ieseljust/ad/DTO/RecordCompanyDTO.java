package com.ieseljust.ad.DTO;

import com.ieseljust.ad.model.RecordCompany;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class RecordCompanyDTO {
	
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idRC;
    
    @Column
    private String name;
    
    @Column
    private String country;

	public int getIdRC() {
		return idRC;
	}

	public void setIdRC(int idRC) {
		this.idRC = idRC;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
    
    public static RecordCompanyDTO convertToDTO(RecordCompany rc) {
    	RecordCompanyDTO rcDTO = new RecordCompanyDTO();
    	rcDTO.setIdRC(rc.getIdRC());
    	rcDTO.setName(rc.getName());
    	rcDTO.setCountry(rc.getCountry());
    	return rcDTO;
    }
    
    public static RecordCompany convertToEntity(RecordCompanyDTO rcDTO) {
		RecordCompany rc = new RecordCompany();
		rc.setIdRC(rcDTO.getIdRC());
		rc.setName(rcDTO.getName());
		rc.setCountry(rc.getCountry());
    	return rc;
    }

}
