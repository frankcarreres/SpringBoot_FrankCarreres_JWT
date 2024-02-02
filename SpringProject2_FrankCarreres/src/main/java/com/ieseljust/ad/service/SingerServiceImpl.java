package com.ieseljust.ad.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ieseljust.ad.DTO.SingerDTO;
import com.ieseljust.ad.model.Singer;
import com.ieseljust.ad.repository.SingerRepository;

@Service
public class SingerServiceImpl implements SingerService {

	@Autowired
	private SingerRepository singerR;
	
	@Override
	public SingerDTO saveSinger(SingerDTO singerDTO) {
		Singer singer = SingerDTO.convertToEntity(singerDTO);	
		singerR.save(singer);
		return singerDTO;
	}

	@Override
	public SingerDTO getSingerById(int id) {
		Optional <Singer>singer = singerR.findById(id);
		if(singer.isPresent()) {
			return SingerDTO.convertToDTO(singer.get());
		}else {
			return null;
		}	
	}

	@Override
	public List<SingerDTO> listAllSingers() {
		List<Singer> llista = singerR.findAll();
		List<SingerDTO> llistaResultat = new ArrayList<SingerDTO>();
		for(int i = 0; i < llista.size(); ++i) {
			llistaResultat.add(SingerDTO.convertToDTO(llista.get(i)));
		}
		return llistaResultat;
	}

	@Override
	public void deleteSinger(int id) {
		singerR.deleteById(id);
	}

}
