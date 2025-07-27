package com.guljo.guljo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guljo.guljo.entity.TokenPassword;

public interface TokenRepository extends JpaRepository<TokenPassword, Integer>{

	TokenPassword findByToken(String token);
}
