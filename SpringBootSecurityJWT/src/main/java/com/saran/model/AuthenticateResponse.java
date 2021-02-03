package com.saran.model;

public class AuthenticateResponse {
	
	private final String jwt;

	public AuthenticateResponse(String jwt) {
		super();
		this.jwt = jwt;
	}

	public String getJwt() {
		return jwt;
	}
	

}
