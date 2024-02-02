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
import com.ieseljust.ad.DTO.AlbumsDTO;
import com.ieseljust.ad.main.SpringProject2FrankCarreresApplication;
import com.ieseljust.ad.service.AlbumsServiceImpl;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class AlbumsController {
	
	private static final Logger myLog=LoggerFactory.getLogger(SpringProject2FrankCarreresApplication.class);
	
	@Autowired
	private AlbumsServiceImpl albumsServiceImpl;
	
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
	
	@GetMapping("/albums")
	public List<AlbumsDTO> listSingers(){
		myLog.info(context.getMethod() + " from " + context.getRemoteHost());
		List<AlbumsDTO> theAlbums = albumsServiceImpl.listAllAlbums();
		return theAlbums;
	}
	
	@GetMapping("/albums/{idAlbums}")
	public AlbumsDTO showAlbumById(@PathVariable Integer idAlbums) {
		myLog.info(context.getMethod() + context.getRemoteHost());
		AlbumsDTO theAlbum = albumsServiceImpl.getAlbumById(idAlbums);
		return theAlbum;
	}
	
	@PostMapping("/albums")
	public ResponseEntity<AlbumsDTO> addAlbum(@RequestBody AlbumsDTO newAlbum){
		myLog.info(context.getMethod() + context.getRequestURI());
		AlbumsDTO theAlbum = albumsServiceImpl.saveAlbum(newAlbum);
			if(theAlbum == null) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			else {
				return new ResponseEntity<>(theAlbum, HttpStatus.OK);
			}
	}
	
	@PutMapping("/albums")
	public ResponseEntity<AlbumsDTO> updateAlbum(@RequestBody AlbumsDTO upAlbum) {
		myLog.info(context.getMethod() + context.getRequestURI());
		AlbumsDTO theAlbum = albumsServiceImpl.getAlbumById(upAlbum.getIdAlbums());
		if(theAlbum == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		else {
			AlbumsDTO theAlbumUPD = albumsServiceImpl.saveAlbum(theAlbum);
			return new ResponseEntity<>(theAlbumUPD, HttpStatus.OK);
		}
	}
	
	
	@DeleteMapping("/albums/{idAlbums}")
	public ResponseEntity<String> deleteAlbum(@PathVariable Integer idAlbums){
		albumsServiceImpl.deleteAlbums(idAlbums);
		return new ResponseEntity<>("The singer has been deleted from the database.",HttpStatus.OK);
		
	}

}
