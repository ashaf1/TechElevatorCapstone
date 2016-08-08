package com.techelevator.model;

import java.util.List;

public interface PotholeDAO {
	
	public void savePothole(Pothole pothole);
	public List getAllPotholes();
	public Pothole getPotholeByID(int id);
	public void updatePothole();
	public void saveLocation(Location location);
}
