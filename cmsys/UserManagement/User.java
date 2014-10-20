package cmsys.UserManagement;

public class User {
	private int uid;
	private int role;
	private String firstName;
	private String lastName;
	private String email;
	private String username;

	public User(int uid, String username, String firstName, String lastName, String email, int role) {
		this.uid = uid;
		this.role = role;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.username = username;
	}
	
	public String getEmail() {
		return email;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getUsername() {
		return username;
	}

	public int getUID() {
		return uid;
	}

	public int getRole() {
		return role;
	}
	
	public void changePassword() {
		
	}
	
	public void changeRole() {
	}
	
}
