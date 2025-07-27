package com.guljo.guljo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import com.guljo.guljo.serviceimpl.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	private CustomUserDetailsService customUserDetailsService;

	@Autowired
	public SecurityConfig(CustomUserDetailsService customUserDetailsService) {
		super();
		this.customUserDetailsService = customUserDetailsService;
	}
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		http.csrf().disable().
		authorizeHttpRequests(auth -> auth
				.requestMatchers("/api/v1/**").permitAll()
				.anyRequest().authenticated())
		.formLogin(
				form -> form.
				loginPage("/api/v1/login").
				loginProcessingUrl("/loginSubmit")
				.defaultSuccessUrl("/api/v1/dashboard")
				.failureHandler(authenticationFailureHandler())
				.permitAll()
				)
		.logout(
				logout -> logout.logoutUrl("/api/v1/logout").
				logoutSuccessUrl("/api/v1/login")
				);
		return http.build();
		
	}
	@Bean
	public AuthenticationFailureHandler authenticationFailureHandler() {
		return new CustomLoginFailureHandler();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		
		return new BCryptPasswordEncoder();
	}
	@Bean
	public DaoAuthenticationProvider provider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(customUserDetailsService);
		provider.setPasswordEncoder(passwordEncoder());
		return provider;
	}
	@Bean
    public BCryptPasswordEncoder passwordsEncoder() {
        return new BCryptPasswordEncoder();
    }
}
