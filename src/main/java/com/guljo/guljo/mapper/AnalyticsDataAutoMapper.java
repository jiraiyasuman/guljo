package com.guljo.guljo.mapper;

import com.guljo.guljo.dto.AnalyticsDataDto;
import com.guljo.guljo.entity.AnalyticsData;

public class AnalyticsDataAutoMapper {

	
	AnalyticsData analyticsData = new AnalyticsData();
	AnalyticsDataDto analyticsDataDto = new AnalyticsDataDto();
	
	public AnalyticsData mapToAnalyticsData(AnalyticsDataDto analyticsDataDto) {
		
		analyticsData.setDurationInSeconds(analyticsDataDto.getDurationInSeconds());
		analyticsData.setEntryTime(analyticsDataDto.getEntryTime());
		analyticsData.setExitTime(analyticsDataDto.getExitTime());
		analyticsData.setIpAddress(analyticsDataDto.getIpAddress());
		analyticsData.setUserAgent(analyticsDataDto.getUserAgent());
		analyticsData.setLatitude(analyticsDataDto.getLatitude());
		analyticsData.setLocation(analyticsDataDto.getLocation());
		analyticsData.setLongitude(analyticsDataDto.getLongitude());
		return analyticsData;
	}
	
	public AnalyticsDataDto mapToAnalyticsDataDto(AnalyticsData analyticsData) {
		analyticsDataDto.setDurationInSeconds(analyticsData.getDurationInSeconds());
		analyticsDataDto.setEntryTime(analyticsData.getEntryTime());
		analyticsDataDto.setExitTime(analyticsData.getExitTime());
		analyticsDataDto.setIpAddress(analyticsData.getIpAddress());
		analyticsDataDto.setUserAgent(analyticsData.getUserAgent());
		analyticsDataDto.setLatitude(analyticsData.getLatitude());
		analyticsDataDto.setLocation(analyticsData.getLocation());
		analyticsDataDto.setLongitude(analyticsData.getLongitude());
		return analyticsDataDto;
		
		
	}
}
