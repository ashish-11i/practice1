package com.progrank1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@SuppressWarnings("deprecation")
@Configuration
public class SecurityConfig {

	//Hamne yaha pe sirf user details service ke functionality ko overide kiya hai
	//custom userdetails service nhi bnaya kewal overide kiya hai
	@Bean
	public UserDetailsService userDetailsService() {
		InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();
		UserDetails ud = User.withUsername("progrank")
		.password("123")
		.authorities("read")
		.build();
		userDetailsManager.createUser(ud);
		return userDetailsManager;
	}
	
	//Authentication provider (UserDetailsService and PasswordEncoder) hmesha password encoder use krta hai yadi isko use nhi krenge iske sath to error dega
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
}
