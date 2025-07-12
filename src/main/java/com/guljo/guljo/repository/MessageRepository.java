package com.guljo.guljo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guljo.guljo.entity.Message;

public interface MessageRepository extends JpaRepository<Message, Integer>{

}
