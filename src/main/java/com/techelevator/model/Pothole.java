package com.techelevator.model;

import java.time.LocalDate;

public class Pothole {
	
//	private static final String LOW_PRIORITY = "Low Priority";
//	private static final String MID_PRIORITY = "Mid Priority";
//	private static final String HIGH_PRIORITY = "High Priority";
	
	
	
	private int potholeId;
	private Location location;
	private String status;
	private String priorityLevel;
	private LocalDate createDate;
	private LocalDate inspectionDate;
	private LocalDate fixedDate;
	
	
	public int getPotholeId() {
		return potholeId;
	}
	
	public void setPotholeId(int potholeId) {
		this.potholeId = potholeId;
	}
	
	public Location getLocation() {
		return location;
	}
	
	public void setLocation(Location location) {
		this.location = location;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPriorityLevel() {
		return priorityLevel;
	}
	
	public void setPriorityLevel(String priorityLevel) {
		this.priorityLevel = priorityLevel;
	}

	public LocalDate getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}

	public LocalDate getInspectionDate() {
		return inspectionDate;
	}

	public void setInspectionDate(LocalDate inspectionDate) {
		this.inspectionDate = inspectionDate;
	}

	public LocalDate getFixedDate() {
		return fixedDate;
	}

	public void setFixedDate(LocalDate fixedDate) {
		this.fixedDate = fixedDate;
	}
	
	

}
