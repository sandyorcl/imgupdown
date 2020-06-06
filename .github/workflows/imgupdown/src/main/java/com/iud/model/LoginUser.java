package com.iud.model;

//import java.io.Serializable;

public class LoginUser {

	//private static final long serialVersionUID = 1L;
	 
	private String first_name;
	private String last_name;
    private String email_id;
    private String password;
    private String gender;
    private String mobile;
    
    public LoginUser() {
	}

	public LoginUser(String first_name, String last_name, String mobile, String email_id, String password,
			String gender) {
		this.first_name = first_name;
		this.last_name = last_name;
		this.email_id = email_id;
		this.password = password;
		this.gender = gender;
		this.mobile = mobile;
	}

	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
    
	@Override
	public String toString() {

		return "First Name: "+ this.first_name +
				"\t Last Name: "+ this.last_name +
				"\t Mobile: "+ this.mobile +
				"\t Email ID: "+ this.email_id +
				"\t Password: "+ this.password +
				"\t Mobile: "+ this.mobile;
	}
}
