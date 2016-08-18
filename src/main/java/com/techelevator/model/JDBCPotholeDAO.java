package com.techelevator.model;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.sql.Array;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JDBCPotholeDAO implements PotholeDAO {
	
	JdbcTemplate jdbcTemplate;
	NamedParameterJdbcOperations namedParameterJdbcOperations; 
	
	@Autowired
	public JDBCPotholeDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public void savePothole(Pothole pothole) {
		
		String sqlSaveLocation = "INSERT INTO location(address_number, street, city, zip, comments) VALUES(?, ?, ?, ?, ?)";
		jdbcTemplate.update(sqlSaveLocation, pothole.getAddressNumber(),pothole.getStreet(), pothole.getCity(), pothole.getZip(), pothole.getComments());
		
		String sqlSearchForLocationId = "SELECT lastval() AS last_location FROM location limit 1";
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
		String sqlSearchForPotholes = "SELECT * FROM pothole JOIN location ON pothole.location_id = location.location_id Order By pothole.pothole_id ASC";
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
		Pothole pothole = new Pothole();
		pothole.setLocationId(results.getInt("location_id"));
		pothole.setAddressNumber(results.getString("address_number"));
		pothole.setStreet(results.getString("street"));
		pothole.setCity(results.getString("city"));
		pothole.setZip(results.getString("zip"));
		pothole.setComments(results.getString("comments"));
		pothole.setPotholeId(results.getInt("pothole_id"));
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
	public List<Pothole> getPotholesNotDuplicateOrRepaired(){
		String sqlGetNonDuplicateOrRepaired = "Select * from pothole "
											+ "Join location on pothole.location_id = location.location_id "
											+ "Where pothole.status <> 'Repaired' AND pothole.status <> 'Duplicate' ";
		List<Pothole> potholes = new ArrayList<>();
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetNonDuplicateOrRepaired);
		while(results.next()) {
			Pothole pothole = getPotholeFromResults(results);
			potholes.add(pothole);
		}
		return potholes;
	}

	@Override
	public List<Pothole> getPotholesByCriteria(String status, String priorityLevel, String city, String street, String zip) {
		List<Pothole> potholes = new ArrayList<>();
		String sqlGetFilteredPotholes = "SELECT * FROM pothole JOIN location ON pothole.location_id = location.location_id WHERE 1=1 ";
		List <String> params = new ArrayList<>();
		
		if(!status.equals("")){
			sqlGetFilteredPotholes += "AND status = ? ";
			params.add(status);
		}
		if(!priorityLevel.equals("")){
			sqlGetFilteredPotholes += "AND priority_level = ? ";
			params.add(priorityLevel);
		}
		if(!city.equals("")){
			sqlGetFilteredPotholes += "AND UPPER(city) = ? ";
			params.add(city.toUpperCase());
		}
		if(!street.equals("")){
			sqlGetFilteredPotholes += "AND UPPER(street) LIKE ? ";
			params.add("%"+street.toUpperCase()+"%");
		}
		if(!zip.equals("")){
			sqlGetFilteredPotholes += "AND zip = ? ";
			params.add(zip);
		}
		sqlGetFilteredPotholes += "ORDER BY pothole.pothole_id ASC";
		Object [] param = params.toArray();
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetFilteredPotholes, param);
		
		while(results.next()){
			Pothole p = getPotholeFromResults(results);
			potholes.add(p);
		}
		return potholes;
	}

	@Override
	public double getAverageRepairTimeInDays() {
		double averageRepairTime = 0;
		String sqlGetAvgRepairTime = "Select cast(avg(fixed_date - create_date) as numeric(10,2)) as avg_repair_time "
									+"From pothole Where status = 'Repaired'";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetAvgRepairTime);
		if(results.next()){
			averageRepairTime = results.getDouble("avg_repair_time");
		}
		return averageRepairTime;
	}
	
	@Override
	public String cityWithMostPotholesAndNumOfPotholes(){
		String cityAndNumOfPotholes = "";
		String sqlGetCityAndNumOfPotholes = "Select count(*) as num_potholes, city from location "
										  + "Join pothole on pothole.location_id = location.location_id "
										  + "Where status <> 'Repaired' AND status <> 'Duplicate' group by city order by num_potholes desc limit 1";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetCityAndNumOfPotholes);
		if(results.next()){
		cityAndNumOfPotholes = Integer.toString(results.getInt("num_potholes")) + " potholes in " +results.getString("city");
		}
		return cityAndNumOfPotholes;
	}
	
	@Override 
	public String streetWithMostPotholes(){
		String streetWithNumOfPotholesAndCity = "";
		String sqlGetStreetWtihPotholesAndCity = "Select count(*) as num_potholes, street, city "
											   + "From location join pothole on pothole.location_id = location.location_id "
											   + "Where status <> 'Repaired' AND status <> 'Duplicate' group by street,city order by count(street) desc limit 1";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetStreetWtihPotholesAndCity);
		if(results.next()){
		streetWithNumOfPotholesAndCity = Integer.toString(results.getInt("num_potholes")) + " potholes on "+results.getString("street")+" in "+results.getString("city");
		}
		return streetWithNumOfPotholesAndCity;
	}
	@Override
	public String zipWithMostPotholes(){
		String zipAndCityWithMostPotholes = "";
		String sqlGetZipAndCityWithMostPotholes = "Select count(*) as num_potholes, zip, city from location "
												+ "Join pothole on pothole.location_id = location.location_id "
												+ "Where status <> 'Repaired' AND status <> 'Duplicate' group by city, zip order by num_potholes desc limit 1";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetZipAndCityWithMostPotholes);
		if(results.next()){
			zipAndCityWithMostPotholes = Integer.toString(results.getInt("num_potholes")) + " potholes in " + results.getString("zip") + ", "+results.getString("city");
		}
		return zipAndCityWithMostPotholes;
	}
}
