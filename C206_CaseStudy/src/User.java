
public class User {
	private String name;
	private String role;
	private String email;
	private String password;
	private boolean deleted;
	
	public User(String name, String role, String email, String password) {
		this.name = name;
		this.role = role;
		this.email = email;
		this.password = password;
		this.deleted = false;
	}
	
	public String getName() {
		return name;
	}
	
	public String getRole() {
		return role;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String toString() {
		String userAccInfo = String.format("%-15s %-15s %-15s", name, role, email);
		return userAccInfo;
	}
	
	public boolean isDeleted() {
		return deleted;
	}
	
	public void setIsDeleted(boolean deleted) {
		this.deleted = deleted;
		
	}
}
