package com.basic.security.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@PreAuthorize("hasRole('USER')")
	@RequestMapping(value = "/") 
	public String test() {
		return "Hello";
	}
	
	
	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(value = "/test") 
	public String testTest() {
		return "Hello test";
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(value = "/hello") 
	public String testHello() {
		return "Hello Hello";
	}
	
}
