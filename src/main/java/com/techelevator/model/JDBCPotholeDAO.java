package com.techelevator.model;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JDBCPotholeDAO implements PotholeDAO {
	
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JDBCPotholeDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public void savePothole() {
		String sqlSearchForLocationId = "SELECT MAX(location_id) AS last_location FROM location";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sqlSearchForLocationId);
		int locationId;
		if(result.next()) {
			locationId = result.getInt("last_location");
			jdbcTemplate.update("INSERT INTO pothole(location_id) VALUES(?)", locationId);
		}
		
	}

	@Override
	public List<Pothole> getAllPotholes() {
		List<Pothole> allPotholes = new ArrayList<>();
		String sqlSearchForPotholes = "SELECT * FROM pothole JOIN location ON pothole.location_id = location.location_id";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSearchForPotholes);
		while(results.next()) {
			Pothole pothole = getPotholeFromResults(results);
			allPotholes.add(pothole);
		}
		return allPotholes;
	}


	@Override
	public Pothole getPotholeByID(int id) {
		Pothole pothole = null;
		String sqlSearchForPotholeById = "SELECT * FROM pothole JOIN location ON pothole.location_id = location.location_id "
										+ "WHERE pothole.pothole_id = ?";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sqlSearchForPotholeById, id);
		if(result.next()) {
			pothole = getPotholeFromResults(result);
		}							
		return pothole;
	}
	
	@Override
	public Pothole getLastPothole() {
		Pothole pothole = null;
		String sqlSearchForPotholeId = "SELECT MAX(pothole_id) AS last_pothole FROM pothole";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sqlSearchForPotholeId);
		int potholeId;
		if(result.next()) {
			potholeId = result.getInt("last_pothole");
			pothole = getPotholeByID(potholeId);
		}
		return pothole;
	}

	@Override
	public void saveLocation(Pothole pothole) {
		String sqlSaveLocation = "INSERT INTO location(street_address, city, zip, comments) VALUES(?, ?, ?, ?)";
		jdbcTemplate.update(sqlSaveLocation, pothole.getStreetAddress(), pothole.getCity(), pothole.getZip(), pothole.getComments());
	}
	
	@Override
	public void updatePotholeStatus(int potholeId, String status) {
		String sqlUpdatePotholeStatus = "UPDATE pothole SET status = ? WHERE pothole_id = ?";
		jdbcTemplate.update(sqlUpdatePotholeStatus, status, potholeId);
	}

	@Override
	public void updatePotholePriority(int potholeId, String priority) {
		String sqlUpdatePotholePriority = "UPDATE pothole SET priority_level = ? WHERE pothole_id = ?";
		jdbcTemplate.update(sqlUpdatePotholePriority, priority, potholeId);
	}

	@Override
	public void updatePotholeInspectionDate(int potholeId, LocalDate date) {
		Date inspectionDate = java.sql.Date.valueOf(date);
		String sqlUpdatePotholeInspectionDate = "UPDATE pothole SET inspection_date = ? WHERE pothole_id = ?";
		jdbcTemplate.update(sqlUpdatePotholeInspectionDate, inspectionDate, potholeId);
	}

	@Override
	public void updatePotholeFixedDate(int potholeId, LocalDate date) {
		Date fixedDate = java.sql.Date.valueOf(date);
		String sqlUpdatePotholeFixedDate = "UPDATE pothole SET fixed_date = ? WHERE pothole_id = ?";
		jdbcTemplate.update(sqlUpdatePotholeFixedDate, fixedDate, potholeId);
	}

	private Pothole getPotholeFromResults(SqlRowSet results) {
		Location location = new Location();
		Pothole pothole = new Pothole();
		pothole.setLocationId(results.getInt("location_id"));
		pothole.setStreetAddress(results.getString("street_address"));
		pothole.setCity(results.getString("city"));
		pothole.setZip(results.getString("zip"));
		pothole.setComments(results.getString("comments"));
		pothole.setPotholeId(results.getInt("pothole_id"));
		pothole.setLocation(location);
		pothole.setStatus(results.getString("status"));
		Date createDate = results.getDate("create_date");
		pothole.setCreateDate(createDate.toLocalDate());
		if(results.getDate("inspection_date") != null) {
			Date inspectionDate = results.getDate("inspection_date");
			pothole.setInspectionDate(inspectionDate.toLocalDate());
		}
		if(results.getDate("fixed_date") != null) {
			Date fixedDate = results.getDate("fixed_date");
			pothole.setFixedDate(fixedDate.toLocalDate());
		}
		if(results.getString("priority_level") != null) {
			pothole.setPriorityLevel(results.getString("priority_level"));
		}
		return pothole;
	}
	
}
