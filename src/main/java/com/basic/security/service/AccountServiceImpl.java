package com.basic.security.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.basic.security.model.Account;

@Component
public class AccountServiceImpl {
	
	/*@Autowired
	private AccountRepository accountRepository ;
	*/
	
	public Account findAccountByUserName(String userName) {
		
		if(userName.equals("rinku")) {
		List<String> roles = new ArrayList<>();
		roles.add("USER");
		roles.add("ADMIN");
		return new Account("rinku","sharma",roles);
		} else {
			return null ;
		}
	}
	

}
