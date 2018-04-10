package com.basic.security.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
class WebSecurityConfig extends WebSecurityConfigurerAdapter {
 
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
    .antMatchers(HttpMethod.PUT, "/**").hasAnyAuthority("ADMIN")
    .antMatchers(HttpMethod.DELETE, "/**").hasAnyAuthority("ADMIN").
    anyRequest().fullyAuthenticated().and().
    httpBasic().and().
    csrf().disable();
  }
  
}