package com.techelevator.model;

public interface UserDAO {

	public void createUser();
	public boolean searchForUsernameAndPassword(String username, String password);
	public void updatePassword(String username, String password);
}
