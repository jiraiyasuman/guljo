package com.guljo.guljo.service;

import com.guljo.guljo.entity.AnalyticsData;

public interface AnalyticsDataService {

	public AnalyticsData saveEntry(String ip,String userAgent);
	public void saveExit(Long id);
}
