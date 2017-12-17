package com.example.demo;

import java.security.Principal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableOAuth2Sso
@RestController
public class SocialApplication extends WebSecurityConfigurerAdapter {

	@RequestMapping("/user")
	public Principal user(final Principal principal) {
		return principal;
	}

	@Override
	protected void configure(final HttpSecurity http) throws Exception {
		http.antMatcher("/**").authorizeRequests().antMatchers("/", "/login**", "/webjars/**").permitAll().anyRequest().authenticated()
				.and().logout().logoutSuccessUrl("/").permitAll().and().csrf()
				.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
	}

	public static void main(final String[] args) {
		SpringApplication.run(SocialApplication.class, args);
	}
}
