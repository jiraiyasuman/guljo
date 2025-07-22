package com.guljo.guljo.entity;
import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity(name="analytics_data")
public class AnalyticsData {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	@Column(name="ip_address")
	private String ipAddress;
	@Column(name="user_agent")
	private String userAgent;
	@Column(name="entry_time")
	private LocalDateTime entryTime;
	@Column(name="exit_time")
	private LocalDateTime exitTime;
	@Column(name="duration_in_seconds")
	private Long durationInSeconds;
	@Column(name="location")
	private String location;
	@Column(name="latitude")
	private double latitude;
	@Column(name="longitude")
	private double longitude;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
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
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public AnalyticsData(long id, String ipAddress, String userAgent, LocalDateTime entryTime, LocalDateTime exitTime,
			Long durationInSeconds, String location, double latitude, double longitude) {
		super();
		this.id = id;
		this.ipAddress = ipAddress;
		this.userAgent = userAgent;
		this.entryTime = entryTime;
		this.exitTime = exitTime;
		this.durationInSeconds = durationInSeconds;
		this.location = location;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	public AnalyticsData() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "AnalyticsData [id=" + id + ", ipAddress=" + ipAddress + ", userAgent=" + userAgent + ", entryTime="
				+ entryTime + ", exitTime=" + exitTime + ", durationInSeconds=" + durationInSeconds + ", location="
				+ location + ", latitude=" + latitude + ", longitude=" + longitude + "]";
	}
		
}
