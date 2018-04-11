package com.basic.security.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@Secured("ROLE_USER")
	@RequestMapping(value = "/") 
	public String test() {
		return "Hello";
	}
	
	
	@Secured({"ROLE_ADMIN","ROLE_USER"})
	@RequestMapping(value = "/test") 
	public String testTest() {
		return "Hello test";
	}
	
	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/hello") 
	public String testHello() {
		return "Hello Hello";
	}
	
	@RequestMapping(value="/logmeout", method = RequestMethod.POST)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	if (auth != null){ 
	new SecurityContextLogoutHandler().logout(request, response, auth);
	}
	return "Logout sucessfully";
	}
}
