package com.guljo.guljo.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.guljo.guljo.service.AnalyticsDataService;

import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

@Component
public class SessionDestroyListener implements HttpSessionListener{

	private AnalyticsDataService analyticsDataService;

	@Autowired
	public SessionDestroyListener(AnalyticsDataService analyticsDataService) {
		super();
		this.analyticsDataService = analyticsDataService;
	}
	
	@Override
    public void sessionDestroyed(HttpSessionEvent se) {
        Long visitorId = (Long) se.getSession().getAttribute("visitorId");
        if (visitorId != null) {
        	analyticsDataService.saveExit(visitorId);
        }
    }
	
}
