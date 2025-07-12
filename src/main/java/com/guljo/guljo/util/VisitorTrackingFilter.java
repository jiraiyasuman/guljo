package com.guljo.guljo.util;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.guljo.guljo.entity.AnalyticsData;
import com.guljo.guljo.service.*;
import java.io.IOException;
@Component
public class VisitorTrackingFilter implements Filter{

	private AnalyticsDataService analyticsDataService;
	@Autowired
	public VisitorTrackingFilter(AnalyticsDataService analyticsDataService) {
		super();
		this.analyticsDataService = analyticsDataService;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession(true);

        if (session.getAttribute("visitorId") == null) {
            String ip = request.getRemoteAddr();
            String agent = req.getHeader("User-Agent");
            AnalyticsData info = analyticsDataService.saveEntry(ip, agent);
            session.setAttribute("visitorId", info.getId());
        }

        chain.doFilter(request, response);

	}

}
