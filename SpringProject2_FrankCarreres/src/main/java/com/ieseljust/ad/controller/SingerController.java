package com.ieseljust.ad.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ieseljust.ad.DTO.SingerDTO;
import com.ieseljust.ad.main.SpringProject2FrankCarreresApplication;
import com.ieseljust.ad.service.SingerServiceImpl;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class SingerController {
	
	private static final Logger myLog=LoggerFactory.getLogger(SpringProject2FrankCarreresApplication.class);
	
	@Autowired
	private SingerServiceImpl singerServiceImpl;
	
	@Autowired
	private HttpServletRequest context;
	@Value("${app.name}")
	private String appName;
	
	@Value("${developer.name}")
	private String devName;
	
	@GetMapping("/")
	public String index() {
		String res = "Hello from Spring\n";
		res+="You are running " + appName + "\n";
		res+="Developed by "+devName;
		return res;
	}
	
	@GetMapping("/singer")
	public List<SingerDTO> listSingers(){
		myLog.info(context.getMethod() + " from " + context.getRemoteHost());
		List<SingerDTO> theSingers = singerServiceImpl.listAllSingers();
		return theSingers;
	}
	
	@GetMapping("/singer/{idSingers}")
	public SingerDTO showSingerById(@PathVariable Integer idSingers) {
		myLog.info(context.getMethod() + context.getRemoteHost());
		SingerDTO theSinger = singerServiceImpl.getSingerById(idSingers);
		return theSinger;
	}
	
	@PostMapping("/singer")
	public ResponseEntity<SingerDTO> addSinger(@RequestBody SingerDTO newSinger){
		myLog.info(context.getMethod() + context.getRequestURI());
		SingerDTO theSinger = singerServiceImpl.saveSinger(newSinger);
			if(theSinger == null) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			else {
				return new ResponseEntity<>(theSinger, HttpStatus.OK);
			}
	}
	
	@PutMapping("/singers")
	public ResponseEntity<SingerDTO> updateSinger(@RequestBody SingerDTO upSinger) {
		myLog.info(context.getMethod() + context.getRequestURI());
		SingerDTO theSinger = singerServiceImpl.getSingerById(upSinger.getIdSingers());
		if(theSinger == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		else {
			SingerDTO theSingerUPD = singerServiceImpl.saveSinger(theSinger);
			return new ResponseEntity<>(theSingerUPD, HttpStatus.OK);
		}
	}
	
	
	@DeleteMapping("/singer/{idSingers}")
	public ResponseEntity<String> deleteSinger(@PathVariable Integer idSingers){
		singerServiceImpl.deleteSinger(idSingers);
		return new ResponseEntity<>("The singer has been deleted from the database.",HttpStatus.OK);
		
	}
	
}

