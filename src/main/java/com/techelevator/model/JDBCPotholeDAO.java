package com.techelevator.model;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

public class JDBCPotholeDAO implements PotholeDAO {
	
	JdbcTemplate jdbcTemplate;
	
	@Override
	public void savePothole(Pothole pothole) {
		
		
	}

	@Override
	public List getAllPotholes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pothole getPotholeByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updatePothole() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveLocation(Location location) {
		// TODO Auto-generated method stub
		
	}

}
