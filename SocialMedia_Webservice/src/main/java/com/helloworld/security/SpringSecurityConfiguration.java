package com.helloworld.security;

import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {

	//Overriding the default filter chain 
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{	
    	//Authenticating all requests
    	httpSecurity.authorizeHttpRequests(auth-> auth.anyRequest().authenticated());
    	
    	//For showing a web page, if not authenticated
    	httpSecurity.httpBasic(withDefaults());
    	
    	//Disable CSRF for POST and PUT requests
    	httpSecurity.csrf().disable();
    	
	 return httpSecurity.build();	
	}
	
	
}
