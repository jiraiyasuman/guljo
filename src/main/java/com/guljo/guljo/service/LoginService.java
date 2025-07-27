package com.guljo.guljo.service;

import com.guljo.guljo.entity.Login;

public interface LoginService {

	public Login updatePassword(Login login);
	public Login addUser(Login login);
	public Login restrictAdmin(Login login);
	
}
