package com.ieseljust.ad.service;

import java.util.List;

import com.ieseljust.ad.DTO.SingerDTO;

public interface SingerService {
	
	SingerDTO saveSinger(SingerDTO singerDTO);
	SingerDTO getSingerById(int id);
	List<SingerDTO> listAllSingers();
	void deleteSinger(int id);

}