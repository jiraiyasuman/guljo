package com.guljo.guljo.service;

import com.guljo.guljo.entity.AnalyticsData;

public interface AnalyticsDataService {

	public AnalyticsData saveEntry(String ip, String userAgent, Double latitude, Double longitude, String location);
	public void saveExit(Long id);
}
