package com.agile.customerservice.services;

import org.springframework.stereotype.Service;

@Service
public class TokenService implements ITokenService {
	
	private static final String TOKEN = "246faa4a-6c8e-430e-92a2-545551f67bfb";

	public boolean isValidToken(String token) {
		if(token.startsWith("Bearer")) {
			String tokenValue = token.substring(7);
			return TOKEN.equals(tokenValue);
		}		
		return false;
	}
}
