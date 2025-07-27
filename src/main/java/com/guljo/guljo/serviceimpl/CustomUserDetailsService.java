package com.guljo.guljo.serviceimpl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.guljo.guljo.config.CustomUserDetails;
import com.guljo.guljo.entity.Login;
import com.guljo.guljo.exception.AccountInactiveException;
import com.guljo.guljo.repository.LoginRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	private LoginRepository loginRepository;
	@Autowired
	public CustomUserDetailsService(LoginRepository loginRepository) {
		super();
		this.loginRepository = loginRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Login login = loginRepository.findByEmail(email);
		if(login == null) {
			throw new UsernameNotFoundException("UserName is not found");
		}
		if(login.isActive()==false) {
			throw new AccountInactiveException("Account is inactive");
		}
		if (login.isAccountLocked()) {
			if (login.getLockTime().plusHours(24).isBefore(LocalDateTime.now())) {
				login.setAccountLocked(false);
				login.setFailedAttempt(0);
				login.setLockTime(null);
				loginRepository.save(login);
			}else {
				throw new LockedException("Account is Locked. Please try after 24 hours");
			}
		}
		return new CustomUserDetails(login);
	}

}
