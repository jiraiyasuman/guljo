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
public class AnalyticsDataServiceImpl implements AnalyticsDataService {

	private AnalyticsDataRepository analyticsDataRepository;

	@Autowired
	public AnalyticsDataServiceImpl(AnalyticsDataRepository analyticsDataRepository) {
		this.analyticsDataRepository = analyticsDataRepository;
	}

	@Transactional
	@Override
	public AnalyticsData saveEntry(String ip, String userAgent, Double latitude, Double longitude, String location) {
		if (latitude == null || longitude == null) {
			// Log warning and avoid saving corrupt data
			System.err.println("Warning: latitude or longitude is null. Skipping analytics entry.");
			return null; // or throw exception if this should never happen
		}

		AnalyticsData analyticsData = new AnalyticsData();
		analyticsData.setIpAddress(ip);
		analyticsData.setUserAgent(userAgent);
		analyticsData.setEntryTime(LocalDateTime.now());
		analyticsData.setLatitude(latitude);
		analyticsData.setLongitude(longitude);
		analyticsData.setLocation(location);

		return analyticsDataRepository.save(analyticsData);	}

	@Transactional
	@Override
	public void saveExit(Long id) {
		analyticsDataRepository.findById(id).ifPresent(analyticsData -> {
			if (analyticsData.getExitTime() == null) {
				LocalDateTime exitTime = LocalDateTime.now();
				analyticsData.setExitTime(exitTime);
				long duration = Duration.between(analyticsData.getEntryTime(), exitTime).getSeconds();
				analyticsData.setDurationInSeconds(duration);
				analyticsDataRepository.save(analyticsData);
			}
		});
	}
}
