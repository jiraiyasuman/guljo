package com.guljo.guljo.mapper;

import com.guljo.guljo.dto.MessageDto;
import com.guljo.guljo.entity.Message;

public class MessageAutoMapper {

	Message message = new Message();
	MessageDto messageDto = new MessageDto();
	
	public Message mapToMessage(MessageDto messageDto) {
		message.setEmail(messageDto.getEmail());
		message.setName(messageDto.getName());
		message.setBody(messageDto.getBody());
		message.setSubject(messageDto.getSubject());
		message.setMobile(messageDto.getMobile());
		message.setStatus(messageDto.getStatus());
		return message;
		
	}
	public MessageDto mapToMessageDto(Message message) {
		messageDto.setEmail(message.getEmail());
		messageDto.setName(message.getName());
		messageDto.setBody(message.getBody());
		messageDto.setMobile(message.getMobile());
		messageDto.setSubject(message.getSubject());
		messageDto.setStatus(message.getStatus());
		return messageDto;
	}
}
