package dev.joshua_coombs.models;

public class Account {
	private int id;
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private int reimbursementAvailable;
	private String accessLevel;
	
	public Account() {
		super();
	}
	
	public Account(int id, String firstName, String lastName, String username, String password,
			int reimbursementAvailable, String accessLevel) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.reimbursementAvailable = reimbursementAvailable;
		this.accessLevel = accessLevel;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getReimbursementAvailable() {
		return reimbursementAvailable;
	}

	public void setReimbursementAvailable(int reimbursementAvailable) {
		this.reimbursementAvailable = reimbursementAvailable;
	}

	public String getAccessLevel() {
		return accessLevel;
	}

	public void setAccessLevel(String accessLevel) {
		this.accessLevel = accessLevel;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", username=" + username
				+ ", password=" + password + ", reimbursementAvailable=" + reimbursementAvailable + ", accessLevel="
				+ accessLevel + "]";
	}
}
