package com.techelevator.model;

import java.time.LocalDate;

public class Pothole {
	
	private static final String LOW_PRIORITY = "Low Priority";
	private static final String MID_PRIORITY = "Mid Priority";
	private static final String HIGH_PRIORITY = "High Priority";
	
	private int potholeId;
	private Location location;
	private boolean doesNotExist;
	private boolean isScheduled;
	private boolean isDuplicate;
	private boolean hasBeenVisited;
	private boolean isFixed;
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
	
	public boolean isDoesNotExist() {
		return doesNotExist;
	}
	
	public void setDoesNotExist(boolean doesNotExist) {
		this.doesNotExist = doesNotExist;
	}
	
	public boolean isScheduled() {
		return isScheduled;
	}
	
	public void setScheduled(boolean isScheduled) {
		this.isScheduled = isScheduled;
	}
	
	public boolean isDuplicate() {
		return isDuplicate;
	}
	
	public void setDuplicate(boolean isDuplicate) {
		this.isDuplicate = isDuplicate;
	}
	
	public boolean isHasBeenVisited() {
		return hasBeenVisited;
	}
	
	public void setHasBeenVisited(boolean hasBeenVisited) {
		this.hasBeenVisited = hasBeenVisited;
	}
	
	public boolean isFixed() {
		return isFixed;
	}
	
	public void setFixed(boolean isFixed) {
		this.isFixed = isFixed;
	}
	
	public String getPriorityLevel() {
		return priorityLevel;
	}
	
	public void setPriorityLevel(String priorityLevel) {
		if(priorityLevel.equals("low")) {
			this.priorityLevel = LOW_PRIORITY;
		} else if (priorityLevel.equals("mid")) {
			this.priorityLevel = MID_PRIORITY;
		} else if (priorityLevel.equals("high")) {
			this.priorityLevel = HIGH_PRIORITY;
		}
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
