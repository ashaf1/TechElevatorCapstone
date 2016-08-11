package com.techelevator.model;

import java.time.LocalDate;
import java.util.List;

public interface PotholeDAO {
	
	public void savePothole(Pothole pothole);
	public List<Pothole> getAllPotholes();
	public Pothole getPotholeByID(int id);
	public void updatePotholeStatus(int potholeId, String status);
	public void updatePotholePriority(int potholeId, String priority);
	public void updatePotholeInspectionDate(int potholeId, LocalDate date);
	public void updatePotholeFixedDate(int potholeId, LocalDate date);
	public Pothole getLastPothole();
	public List<Pothole> getPotholesByStatus();
	public List<Pothole> getPotholesByPriorityLevel();
	public List<Pothole> getPotholesByCity();
	public List<Pothole> getPotholesByStreetAddress();
	public List<Pothole> getPotholeByZip();
}
