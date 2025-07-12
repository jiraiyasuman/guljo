package com.guljo.guljo.serviceimpl;

import java.time.Duration;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guljo.guljo.entity.AnalyticsData;
import com.guljo.guljo.repository.AnalyticsDataRepository;
import com.guljo.guljo.service.AnalyticsDataService;

import jakarta.transaction.Transactional;
@Service
public class AnalyticsDataServiceImpl implements AnalyticsDataService{

	private AnalyticsDataRepository analyticsDataRepository;
	@Autowired
	public AnalyticsDataServiceImpl(AnalyticsDataRepository analyticsDataRepository) {
		super();
		this.analyticsDataRepository = analyticsDataRepository;
	}

	@Transactional
	@Override
	public AnalyticsData saveEntry(String ip, String userAgent) {
		AnalyticsData analyticsData = new AnalyticsData();
		analyticsData.setIpAddress(ip);
		analyticsData.setUserAgent(userAgent);
		analyticsData.setEntryTime(LocalDateTime.now());
		
		return analyticsDataRepository.save(analyticsData);
	}

	@Transactional
	@Override
	public void saveExit(Long id) {
		AnalyticsData analyticsData = analyticsDataRepository.findById(id).get();
		if(analyticsData !=null && analyticsData.getExitTime() == null) {
			LocalDateTime exitTime = LocalDateTime.now();
			analyticsData.setExitTime(exitTime);
			long duration = Duration.between(analyticsData.getEntryTime(), exitTime).getSeconds();
			analyticsData.setDurationInSeconds(duration);
			analyticsDataRepository.save(analyticsData);
		}
		
	}

}
