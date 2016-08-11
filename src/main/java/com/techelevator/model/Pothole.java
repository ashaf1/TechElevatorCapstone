package com.techelevator.model;

import java.time.LocalDate;

public class Pothole {
	
//	private static final String LOW_PRIORITY = "Low Priority";
//	private static final String MID_PRIORITY = "Mid Priority";
//	private static final String HIGH_PRIORITY = "High Priority";
	
	
	
	private int potholeId;
	private String status;
	private String priorityLevel;
	private LocalDate createDate;
	private LocalDate inspectionDate;
	private LocalDate fixedDate;
	private int locationId;
	private String streetAddress;
	private String city;
	private String zip;
	private String comments;
	
	public Pothole(){
		this.comments = "N/A";
	}
	
	public int getPotholeId() {
		return potholeId;
	}
	
	public void setPotholeId(int potholeId) {
		this.potholeId = potholeId;
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

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
	
	

}
