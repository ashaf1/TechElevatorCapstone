package com.techelevator.model;

import javax.sql.DataSource;

import org.bouncycastle.util.encoders.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.security.PasswordHasher;

public class JDBCUserDAO implements UserDAO {

	private JdbcTemplate jdbcTemplate;
	private PasswordHasher passwordHasher;
	
	@Autowired
	public JDBCUserDAO(DataSource dataSource, PasswordHasher passwordHasher) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.passwordHasher = passwordHasher;
	}
	
	@Override
	public void createUser(User user) {
		byte[] salt = passwordHasher.generateRandomSalt();
		String hashedPassword = passwordHasher.computeHash(user.getPassword(), salt);
		String saltString = new String(Base64.encode(salt));
		String sqlSaveUser = "INSERT INTO user_table(role, first_name, last_name, user_name, password, salt) VALUES (?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(sqlSaveUser, user.getRole(), user.getFirstName(), user.getLastName(), user.getUserName(), hashedPassword, saltString);
	}

	@Override
	public boolean searchForUsernameAndPassword(String username, String password) {
		String sqlSearchForUser = "SELECT * "+
			      "FROM user_table "+
			      "WHERE UPPER(user_name) = ?";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSearchForUser, username.toUpperCase());
		if(results.next()) {
			String storedSalt = results.getString("salt");
			String storedPassword = results.getString("password");
			String hashedPassword = passwordHasher.computeHash(password, Base64.decode(storedSalt));
			return storedPassword.equals(hashedPassword);
		} else {
			return false;
		}
	}

	@Override
	public void updatePassword(String username, String password) {
		byte[] salt = passwordHasher.generateRandomSalt();
		String hashedPassword = passwordHasher.computeHash(password, salt);
		String saltString = new String(Base64.encode(salt));
		jdbcTemplate.update("UPDATE user_table SET password = ?, salt = ? WHERE user_name = ?", hashedPassword, saltString, username);
	}

}
