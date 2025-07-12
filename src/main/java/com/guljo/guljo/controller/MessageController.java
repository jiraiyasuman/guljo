package com.guljo.guljo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.hibernate.validator.internal.util.privilegedactions.GetClassLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.guljo.guljo.dto.MessageDto;
import com.guljo.guljo.entity.Message;
import com.guljo.guljo.entity.Student;
import com.guljo.guljo.mapper.MessageAutoMapper;
import com.guljo.guljo.service.MessageService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1/message")
public class MessageController {

	private MessageService messageService;

	private MessageAutoMapper messageAutoMapper =new MessageAutoMapper();
	@Autowired
	public MessageController(MessageService messageService) {
		super();
		this.messageService = messageService;
	}
	
	private  final Logger LOGGER = Logger.getLogger(getClass().getName());
	@PostMapping("save")
	public ResponseEntity<MessageDto> saveMessage(@Valid @RequestBody MessageDto messageDto){
		Message message = messageAutoMapper.mapToMessage(messageDto);
		message.setStatus("Pending");
		Message savedMessage = messageService.addMessage(message);
		MessageDto saveMessageDto = messageAutoMapper.mapToMessageDto(savedMessage);
		LOGGER.info("Controller Save repo is being executed");
		return ResponseEntity.ok(saveMessageDto);
	}
	@GetMapping("list")
	public ResponseEntity<Map<String,Object>> getAll(){
		return findPaginated(1,"name","asc");
	}
	@GetMapping("list/page/{pageNo}")
	public ResponseEntity<Map<String,Object>> findPaginated(
			@PathVariable("pageNo") int pageNo,
			@RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir
			){
		int pageSize = 10;
		Page<Message> page = messageService.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<Message> listMessages = page.getContent();
		
		Map<String,Object> response =  new HashMap<>();
		
		response.put("currentPage", pageNo);
		response.put("totalElements", page.getTotalElements());
		response.put("totalPages", page.getTotalPages());
		response.put("sortField", sortField);
		response.put("sortDir", sortDir);
		response.put("reverseSortDir", sortDir.equals("asc")?"desc":"asc");
		response.put("listStudents", listMessages);
		return ResponseEntity.ok(response);
	}
	@GetMapping("list/{id}")
	public ResponseEntity<MessageDto> getById(@PathVariable("id") int id){
	Message message = messageService.getMessageById(id);
	MessageDto messageDto = messageAutoMapper.mapToMessageDto(message);
	LOGGER.info("Controller find by id is being executed");
	return ResponseEntity.ok(messageDto);
   }
	@GetMapping("update/{id}")
   public ResponseEntity<MessageDto> updateMessage(@PathVariable("id") int id, @Valid @RequestBody MessageDto messageDto){
	   Message message = messageAutoMapper.mapToMessage(messageDto);
	   Message updateMessage = messageService.updateMessage(id, message);
	   MessageDto updateMessageDto = messageAutoMapper.mapToMessageDto(updateMessage);
	   return ResponseEntity.ok(messageDto);
	   
	   
   }
}