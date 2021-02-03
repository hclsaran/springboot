package com.saran.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.saran.config.MyUserDetailsService;
import com.saran.jwt.JWTUtility;
import com.saran.model.AuthenticateRequest;
import com.saran.model.AuthenticateResponse;

@RestController
public class SaranController {
	@Autowired
	private AuthenticationManager auth;
	@Autowired
	private MyUserDetailsService userDetailsService;
	
	@Autowired
	private JWTUtility jwtutil;

	
	
	@GetMapping("/")
	public String accessBusinessLogic() {
		return "Accessing your business logic";
	}
	
	@PostMapping("/authenticate")
	public ResponseEntity<?> createAuthenicationToken(@RequestBody AuthenticateRequest req) throws 
	Exception{
		try {
	   auth.authenticate(new UsernamePasswordAuthenticationToken(req.getUsername(),req.getPassword()));	
		}catch(BadCredentialsException e) {throw new Exception("Invalid UserName and Password",e);}
	
	final UserDetails userDetails=userDetailsService.loadUserByUsername(req.getUsername());
	
	final String jwt=jwtutil.generateToken(userDetails);
	return ResponseEntity.ok(new AuthenticateResponse(jwt));//200
	}

}
