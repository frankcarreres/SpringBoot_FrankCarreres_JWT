package com.ieseljust.ad.service;

import java.util.List;
import com.ieseljust.ad.DTO.RecordCompanyDTO;

public interface RecordCompanyService {
	
	RecordCompanyDTO saveRC(RecordCompanyDTO rcDTO);
	RecordCompanyDTO getRecordCompanyById(int id);
	List<RecordCompanyDTO> listAllRC();
	void deleteRecordCompany(int id);

}
