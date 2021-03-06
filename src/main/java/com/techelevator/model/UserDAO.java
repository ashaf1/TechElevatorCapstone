package com.techelevator.model;

public interface UserDAO {

	public void createUser(User user);
	public boolean searchForUsernameAndPassword(String username, String password);
	public void updatePassword(String username, String password);
	public User getUserByUsernameAndPassword(String username, String password);
}
