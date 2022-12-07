package com.agile.customerservice.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.agile.customerservice.services.ITokenService;

@Component
public class WebRequestHandler implements HandlerInterceptor {
	private ITokenService tokenService;
	
	public WebRequestHandler(ITokenService tokenService) {
		this.tokenService = tokenService;
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		String authHeader = request.getHeader("Authorization");
		
		if(authHeader!= null &&  tokenService.isValidToken(authHeader)) {
			request.authenticate(response);
			
		}	
		else {
			response.sendError(401, "Unauthorized");
		}		
		return HandlerInterceptor.super.preHandle(request, response, handler);
		
	}
}
