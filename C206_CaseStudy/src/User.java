
public class User {
	private String name;
	private String role;
	private String email;
	private String password;
	
	public User(String name, String role, String email, String password) {
		this.name = name;
		this.role = role;
		this.email = email;
		this.password = password;
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
}
