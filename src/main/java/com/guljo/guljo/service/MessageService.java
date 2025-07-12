package com.guljo.guljo.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.guljo.guljo.entity.Message;
import com.guljo.guljo.entity.Student;

public interface MessageService {

	public Message addMessage(Message message);
	public List<Message> getAll();
	public Message updateMessage(int id,Message message);
	public Message getMessageById(int id);
	public Page<Message> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
	
}
