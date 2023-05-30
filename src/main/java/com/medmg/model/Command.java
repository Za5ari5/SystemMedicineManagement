package com.medmg.model;

public class Command {
	
	private int id;
	private int user_id;
	private int medicine_id;
	private int quantity;
	private String command_date; 
	private String commander_name;
	private String medicine_name;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	







	public String getCommander_name() {
		return commander_name;
	}






	public void setCommander_name(String commander_name) {
		this.commander_name = commander_name;
	}






	public String getMedicine_name() {
		return medicine_name;
	}






	public void setMedicine_name(String medicine_name) {
		this.medicine_name = medicine_name;
	}






	public Command() {

		
	}
	
	
	
	
	
	
	public Command(int id, int user_id, int medicine_id, int quantity, String command_date , String commander_name, String medicine_name) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.medicine_id = medicine_id;
		this.quantity = quantity;
		this.command_date = command_date;
		this.commander_name = commander_name;
		this.medicine_name = medicine_name;
		
		
	}
	
	
	
	
	
	
	public String getCommand_date() {
		return command_date;
	}

	public void setCommand_date(String command_date) {
		this.command_date = command_date;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getMedicine_id() {
		return medicine_id;
	}
	public void setMedicine_id(int medicine_id) {
		this.medicine_id = medicine_id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	

}
