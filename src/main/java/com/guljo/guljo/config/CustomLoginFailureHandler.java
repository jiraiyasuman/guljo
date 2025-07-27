package com.guljo.guljo.config;

import java.io.IOException;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import com.guljo.guljo.entity.Login;
import com.guljo.guljo.repository.LoginRepository;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@Component
public class CustomLoginFailureHandler implements AuthenticationFailureHandler{

	
	private LoginRepository loginRepository;
	@Autowired
	public CustomLoginFailureHandler(LoginRepository loginRepository) {
		super();
		this.loginRepository = loginRepository;
	}

	
	public CustomLoginFailureHandler() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		String email = request.getParameter("username");
        Login user = loginRepository.findByEmail(email);

        if (user != null) {
            if (!user.isAccountLocked()) {
                int attempts = user.getFailedAttempt() + 1;
                user.setFailedAttempt(attempts);

                if (attempts >= 3) {
                    user.setAccountLocked(true);
                    user.setLockTime(LocalDateTime.now());
                }

                loginRepository.save(user);
            }
        }

        response.sendRedirect("/login?error=true");
	}

}
