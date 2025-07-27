package com.guljo.guljo.serviceimpl;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.guljo.guljo.entity.Login;
import com.guljo.guljo.entity.Message;
import com.guljo.guljo.entity.TokenPassword;
import com.guljo.guljo.repository.LoginRepository;
import com.guljo.guljo.repository.TokenRepository;
import com.guljo.guljo.service.LoginService;

import jakarta.mail.internet.MimeMessage;
import jakarta.transaction.Transactional;
@Service
public class LoginServiceImpl implements LoginService{

	private LoginRepository loginRepository;
	private JavaMailSender javaMailSender;
	private final Logger LOGGER = Logger.getLogger(getClass().getName());
	private TokenRepository tokenRepository;
	

	
	public LoginServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	@Transactional
	public Login updatePassword(Login login) {
		Login updatedLogin = loginRepository.save(login);
		return updatedLogin;
	}

	@Override
	@Transactional
	public Login addUser(Login login) {
		Login savedLogin = loginRepository.save(login);
		return savedLogin;
	}

	public void sendMail(Login login,String subject,String body) {
		String from ="guljocare@gmail.com";
		String to = login.getEmail();
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
			LOGGER.info("Executing the sendEmail component in the LoginServiceImpl class");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}


	@Override
	public Login restrictAdmin(Login login) {
		Login deletedLogin = loginRepository.save(login);
		return deletedLogin;
	}
	public String sendEmail(Login user) {
		try {
			String resetLink = generateResetToken(user);

			SimpleMailMessage msg = new SimpleMailMessage();
			msg.setFrom("guljocare@gmail.com");
			msg.setTo(user.getEmail());

			msg.setSubject("Welcome To Guljo Engineering Solutions");
			msg.setText("Hello \n\n" + "Please click on this link to Reset your Password :" + resetLink + ". \n\n"
					+ "Regards \n" + "Guljo Engineering Solutions");

			javaMailSender.send(msg);

			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}

	}


	public String generateResetToken(Login user) {
		UUID uuid = UUID.randomUUID();
		LocalDateTime currentDateTime = LocalDateTime.now();
		LocalDateTime expiryDateTime = currentDateTime.plusMinutes(30);
		TokenPassword resetToken = new TokenPassword();
		resetToken.setToken(uuid.toString());
		resetToken.setExpiryDateTime(expiryDateTime);
		TokenPassword token = tokenRepository.save(resetToken);
		if (token != null) {
			String endpointUrl = "http://localhost:8081/resetPassword";
			return endpointUrl + "/" + resetToken.getToken();
		}
		return "";
	}


	public boolean hasExipred(LocalDateTime expiryDateTime) {
		LocalDateTime currentDateTime = LocalDateTime.now();
		return expiryDateTime.isAfter(currentDateTime);
	}
}
