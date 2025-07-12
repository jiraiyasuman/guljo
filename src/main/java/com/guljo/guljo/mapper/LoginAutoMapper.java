package com.guljo.guljo.mapper;

import com.guljo.guljo.dto.LoginDto;
import com.guljo.guljo.entity.Login;

public class LoginAutoMapper {

	Login login = new Login();
	LoginDto loginDto = new LoginDto();
	public Login mapToLogin(LoginDto loginDto) {
		login.setEmail(loginDto.getEmail());
		login.setName(loginDto.getName());
		login.setMobile(loginDto.getMobile());
		login.setName(loginDto.getName());
		login.setPassword(loginDto.getPassword());
		return login;
	}
	public LoginDto mapToLoginDto(Login login) {
		loginDto.setEmail(login.getEmail());
		loginDto.setName(login.getName());
		loginDto.setPassword(login.getPassword());
		loginDto.setMobile(login.getMobile());
		return loginDto;
	}
}
