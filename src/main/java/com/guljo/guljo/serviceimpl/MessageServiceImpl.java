package com.guljo.guljo.serviceimpl;

import java.util.List;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.guljo.guljo.entity.Message;
import com.guljo.guljo.entity.Student;
import com.guljo.guljo.exception.NotFoundException;
import com.guljo.guljo.repository.MessageRepository;
import com.guljo.guljo.service.MessageService;

import jakarta.mail.internet.MimeMessage;
import jakarta.transaction.Transactional;
@Service
public class MessageServiceImpl implements MessageService{

	private MessageRepository messageRepository;
	private final Logger LOGGER = Logger.getLogger(getClass().getName());
	private JavaMailSender javaMailSender;
	

	@Autowired
	public MessageServiceImpl(MessageRepository messageRepository, JavaMailSender javaMailSender) {
		super();
		this.messageRepository = messageRepository;
		
		this.javaMailSender = javaMailSender;
	}

	@Transactional
	@Override
	public Message addMessage(Message message) {
		Message savedMessage = messageRepository.save(message);
		String guljoMessage = "Dear Guljo, <br>  You have a new message, please check and take action. <br> Kind Regards, <br>Team Guljo";
		String clientMessage = "Dear "+message.getName()+", <br> Someone from team Guljo will contact you and resolve your queries within 24 hours.<br> Kind Regards, <br> Team Guljo";
		String subjectGuljo = "Query";
		String subjectClient="Query Submission Acknowledgement";
		sendMail(message, subjectClient,clientMessage );
		sendMailGuljo("guljocare@gmail.com", subjectGuljo, guljoMessage);
		LOGGER.info("Message Insertion is executed sucessfully");
		return savedMessage;
	}

	@Override
	public List<Message> getAll() {
		List<Message> getMessage = messageRepository.findAll();
		LOGGER.info("Find All Messages is executed sucessfully");
		return getMessage;
	}

	@Transactional
	@Override
	public Message updateMessage(int id, Message message) {
		Message getMessage = messageRepository.findById(id).get();
		if(getMessage==null) {
			LOGGER.warning("Message Not found");
			throw new NotFoundException("Message not found");
		}
		getMessage.setStatus(message.getStatus());
		Message updatedMessage = messageRepository.save(getMessage);
		LOGGER.info("Message Updation is executed sucessfully");
		return updatedMessage;
	}

	@Override
	public Message getMessageById(int id) {
		Message getMessage = messageRepository.findById(id).get();
		if(getMessage==null) {
			LOGGER.warning("Message Not found");
			throw new NotFoundException("Message not found");
		}
		LOGGER.info(" Get Message By Id is executed sucessfully");
		return getMessage;
	}

	public void sendMail(Message message,String subject,String body) {
		String from ="guljocare@gmail.com";
		String to = message.getEmail();
		if(to.trim().isEmpty()) {
			throw new IllegalArgumentException("Recipient email should not be null");
			
		}
		try {
			
			MimeMessage msg = javaMailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(msg);
			helper.setFrom(from,"Guljo Engineering Solutions");
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(body,true);
			javaMailSender.send(msg);
			LOGGER.info("Executing the sendEmail component in the MessageService class");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public void sendMailGuljo(String to,String subject,String body) {
		String from ="guljocare@gmail.com";
		
		if(to.trim().isEmpty()) {
			throw new IllegalArgumentException("Recipient email should not be null");
			
		}
		try {
			
			MimeMessage msg = javaMailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(msg);
			helper.setFrom(from, "MujUnityFest 2025");
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(body,true);
			javaMailSender.send(msg);
			LOGGER.info("Executing the sendEmail component in the MessageService class");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Page<Message> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending():
			Sort.by(sortField).descending();
		Pageable pageable = PageRequest.of(pageNo-1, pageSize,sort);
		return this.messageRepository.findAll(pageable);
	}
}
