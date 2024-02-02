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
import com.ieseljust.ad.DTO.RecordCompanyDTO;
import com.ieseljust.ad.main.SpringProject2FrankCarreresApplication;
import com.ieseljust.ad.service.RecordCompanyServiceImpl;
import jakarta.servlet.http.HttpServletRequest;

@RestController
public class RecordCompanyController {
	
	private static final Logger myLog=LoggerFactory.getLogger(SpringProject2FrankCarreresApplication.class);
	
	@Autowired
	private RecordCompanyServiceImpl rcServiceImpl;
	
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
	
	@GetMapping("/rc")
	public List<RecordCompanyDTO> listRC(){
		myLog.info(context.getMethod() + " from " + context.getRemoteHost());
		List<RecordCompanyDTO> theRCS = rcServiceImpl.listAllRC();
		return theRCS;
	}
	
	@GetMapping("/rc/{idRC}")
	public RecordCompanyDTO showRCById(@PathVariable Integer idRC) {
		myLog.info(context.getMethod() + context.getRemoteHost());
		RecordCompanyDTO thRC = rcServiceImpl.getRecordCompanyById(idRC);
		return thRC;
	}
	
	@PostMapping("/rc")
	public ResponseEntity<RecordCompanyDTO> addRC(@RequestBody RecordCompanyDTO newRC){
		myLog.info(context.getMethod() + context.getRequestURI());
		RecordCompanyDTO thRC = rcServiceImpl.saveRC(newRC);
			if(thRC == null) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			else {
				return new ResponseEntity<>(thRC, HttpStatus.OK);
			}
	}
	
	@PutMapping("/rc")
	public ResponseEntity<RecordCompanyDTO> updateRC(@RequestBody RecordCompanyDTO upRC) {
		myLog.info(context.getMethod() + context.getRequestURI());
		RecordCompanyDTO theRC = rcServiceImpl.getRecordCompanyById(upRC.getIdRC());
		if(theRC == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		else {
			RecordCompanyDTO theAlbumUPD = rcServiceImpl.saveRC(theRC);
			return new ResponseEntity<>(theAlbumUPD, HttpStatus.OK);
		}
	}
	
	
	@DeleteMapping("/rc/{idRC}")
	public ResponseEntity<String> deleteRC(@PathVariable Integer idRC){
		rcServiceImpl.deleteRecordCompany(idRC);
		return new ResponseEntity<>("The Record Company has been deleted from the database.",HttpStatus.OK);		
	}

}
