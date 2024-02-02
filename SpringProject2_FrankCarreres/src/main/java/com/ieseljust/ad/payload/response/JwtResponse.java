package com.ieseljust.ad.payload.response;

import java.util.List;

public class JwtResponse {
	private String token;
	private String type = "Bearer";	
	private Long Id;
	private String username;
	private List<String>roles;
	public String getToken() {
	return token;
}
	public void setToken(String token) {
		this.token = token;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public Long getId() {
		return Id;
	}
	
	public void setId(Long id) {
		Id = id;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public List<String> getRoles() {
		return roles;
	}
	
	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	
	public JwtResponse(Long id, String username, List<String> roles) {
		super();
		Id = id;
		this.username = username;
		this.roles = roles;
	}



}
