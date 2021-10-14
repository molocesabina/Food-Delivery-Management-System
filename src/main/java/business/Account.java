package business;

import java.io.Serializable;

/**
* Account class for users:admin, employee, client
* @author Moloce Sabina
*/
public class Account implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2118375772109623711L;
	private int id;
	private String username;
	private String password;
	private String role;
	
	/**
	 * Constructor with 4 parameters
	 * @param id
	 * @param username
	 * @param password
	 * @param role
	 */
	public Account(int id,String username,String password, String role) {
		this.id = id;
		this.username = username;
		this.password = password;
	    this.role = role;
	}
	
	/**
	 * Construtor with 3 parameters
	 * @param username
	 * @param password
	 * @param role
	 */
	public Account(String username,String password, String role) {
		this.username = username;
		this.password = password;
	    this.role = role;
	}
	
	public int getId() {
		return id;
	}
	
	
	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
	
	public String getRole() {
		return role;
	}

	

	

}
