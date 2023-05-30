package com.medmg.model;

public class User {
	private int id;
	private String username;
	private String password;
	private String first_name;
	private String last_name;
	private String medical_facility_name;
	private String service;
	private String email;
	private String role;
	public User() {}
	public User(int id, String username, String password, String first_name, String last_name,
			String medical_facility_name, String service, String email, String role) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.first_name = first_name;
		this.last_name = last_name;
		this.medical_facility_name = medical_facility_name;
		this.service = service;
		this.email = email;
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
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public String getMedical_facility_name() {
		return medical_facility_name;
	}
	public void setMedical_facility_name(String medical_facility_name) {
		this.medical_facility_name = medical_facility_name;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
	
	
}
