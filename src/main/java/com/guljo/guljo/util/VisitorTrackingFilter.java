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
import com.guljo.guljo.service.AnalyticsDataService;

import java.io.IOException;

@Component
public class VisitorTrackingFilter implements Filter {

    private final AnalyticsDataService analyticsDataService;

    private ReverseGeocodingUtil reverseGeocodingUtil;
    @Autowired
    public VisitorTrackingFilter(AnalyticsDataService analyticsDataService, ReverseGeocodingUtil reverseGeocodingUtil) {
		super();
		this.analyticsDataService = analyticsDataService;
		this.reverseGeocodingUtil = reverseGeocodingUtil;
	}


	@Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession(true);

        if (session.getAttribute("visitorId") == null) {
            String ip = request.getRemoteAddr();
            String agent = req.getHeader("User-Agent");

            String latParam = request.getParameter("latitude");
            String lonParam = request.getParameter("longitude");
            String location = request.getParameter("location");

            Double latitude = null;
            Double longitude = null;

            try {
                if (latParam != null) latitude = Double.parseDouble(latParam);
                if (lonParam != null) longitude = Double.parseDouble(lonParam);
            } catch (NumberFormatException e) {
                System.err.println("Invalid coordinates.");
            }

            // 🔁 Reverse geocode if location is not provided
            if ((location == null || location.isEmpty()) && latitude != null && longitude != null) {
                location = reverseGeocodingUtil.getLocationFromCoordinates(latitude, longitude);
            }

            AnalyticsData info = analyticsDataService.saveEntry(ip, agent, latitude, longitude, location);
            if (info != null) {
                Long id = info.getId();
                session.setAttribute("analyticsId", id);
            } else {
                // Optional: log or debug why it returned null
                System.err.println("Analytics entry not saved (possibly due to missing location info).");
            }
        }

        chain.doFilter(request, response);
    }
}
