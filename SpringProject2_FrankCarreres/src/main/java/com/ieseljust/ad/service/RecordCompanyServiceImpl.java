package com.ieseljust.ad.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.ieseljust.ad.DTO.RecordCompanyDTO;
import com.ieseljust.ad.model.RecordCompany;
import com.ieseljust.ad.repository.RecordCompanyRepository;


public class RecordCompanyServiceImpl implements RecordCompanyService{
	
	@Autowired
	private RecordCompanyRepository rcR;

	@Override
	public RecordCompanyDTO saveRC(RecordCompanyDTO rcDTO) {
		RecordCompany rc = RecordCompanyDTO.convertToEntity(rcDTO);
		rcR.save(rc);
		return rcDTO;
		
	}

	@Override
	public RecordCompanyDTO getRecordCompanyById(int id) {
		Optional<RecordCompany>rc = rcR.findById(id);
		if(rc.isPresent()) {
			return RecordCompanyDTO.convertToDTO(rc.get());
		}else {
			return null;
		}
	}

	@Override
	public List<RecordCompanyDTO> listAllRC() {
		List<RecordCompany> llista = rcR.findAll();
		List<RecordCompanyDTO> llistaResultat = new ArrayList<RecordCompanyDTO>();
		for(int i = 0; i < llista.size(); ++i) {
			llistaResultat.add(RecordCompanyDTO.convertToDTO(llista.get(i)));
		}
		return llistaResultat;
	}

	@Override
	public void deleteRecordCompany(int id) {
		rcR.deleteById(id);
	}

}
