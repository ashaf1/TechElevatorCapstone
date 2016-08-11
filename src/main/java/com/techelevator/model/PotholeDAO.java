package com.techelevator.model;

import java.time.LocalDate;
import java.util.List;

public interface PotholeDAO {
	
	public void savePothole();
	public List<Pothole> getAllPotholes();
	public Pothole getPotholeByID(int id);
	public void updatePotholeStatus(int potholeId, String status);
	public void updatePotholePriority(int potholeId, String priority);
	public void updatePotholeInspectionDate(int potholeId, LocalDate date);
	public void updatePotholeFixedDate(int potholeId, LocalDate date);
	public void saveLocation(Pothole pothole);
	public Pothole getLastPothole();
}
