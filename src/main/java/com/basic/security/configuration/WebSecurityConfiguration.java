package com.basic.security.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.basic.security.model.Account;
import com.basic.security.service.AccountServiceImpl;

@Configuration
class WebSecurityConfiguration extends GlobalAuthenticationConfigurerAdapter {

 
	@Autowired
	private AccountServiceImpl accountService;

  @Override
  public void init(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userDetailsService());
  }

  @Bean
  UserDetailsService userDetailsService() {
    return new UserDetailsService() {

      @Override
      public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Account account = accountService.findAccountByUserName(userName);
        if(account != null) {
        //return new User(account.getUserName(), account.getPassword(), true, true, true, true,
        	//	createAuthorityList(account.getRoles()));
        return User.withDefaultPasswordEncoder().username(account.getUserName()).password(account.getPassword()).roles(account.getRoles().toArray(new String[account.getRoles().size()])).build();
        
        } else {
          throw new UsernameNotFoundException("could not find the user '"
                  + userName + "'");
        }
      }
      
    };
  }
  
  public static List<GrantedAuthority> createAuthorityList(List<String> roles) {
		List<GrantedAuthority> authorities = new ArrayList<>(roles.size());

		for (String role : roles) {
			authorities.add(new SimpleGrantedAuthority(role));
		}

		return authorities;
	}
 
  
}

