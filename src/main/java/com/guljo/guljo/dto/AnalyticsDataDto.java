package com.guljo.guljo.dto;

import java.time.LocalDateTime;

import org.antlr.v4.runtime.misc.NotNull;

import io.swagger.v3.oas.annotations.media.Schema;

public class AnalyticsDataDto {

	@Schema
	private String ipAddress;
	@Schema
    private String userAgent;
	@Schema
    private LocalDateTime entryTime;
	@Schema
    private LocalDateTime exitTime;
	@Schema
    private Long durationInSeconds;
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public String getUserAgent() {
		return userAgent;
	}
	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}
	public LocalDateTime getEntryTime() {
		return entryTime;
	}
	public void setEntryTime(LocalDateTime entryTime) {
		this.entryTime = entryTime;
	}
	public LocalDateTime getExitTime() {
		return exitTime;
	}
	public void setExitTime(LocalDateTime exitTime) {
		this.exitTime = exitTime;
	}
	public Long getDurationInSeconds() {
		return durationInSeconds;
	}
	public void setDurationInSeconds(Long durationInSeconds) {
		this.durationInSeconds = durationInSeconds;
	}
	public AnalyticsDataDto(String ipAddress, String userAgent, LocalDateTime entryTime, LocalDateTime exitTime,
			Long durationInSeconds) {
		super();
		this.ipAddress = ipAddress;
		this.userAgent = userAgent;
		this.entryTime = entryTime;
		this.exitTime = exitTime;
		this.durationInSeconds = durationInSeconds;
	}
	public AnalyticsDataDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "AnalyticsDataDto [ipAddress=" + ipAddress + ", userAgent=" + userAgent + ", entryTime=" + entryTime
				+ ", exitTime=" + exitTime + ", durationInSeconds=" + durationInSeconds + "]";
	}
}
