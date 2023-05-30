package com.medmg.model;

public class Medicine {
	private int id ;
	private String name;
	private String type;
	private String category;
	private String production_date;
	private String expiration_date;
	private int quantity;
	public Medicine() {}
	public Medicine(int id, String name, String type, String category, String production_date, String expiration_date , int quantity) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.category = category;
		this.production_date = production_date;
		this.expiration_date = expiration_date;
		this.quantity = quantity;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getProduction_date() {
		return production_date;
	}
	public void setProduction_date(String production_date) {
		this.production_date = production_date;
	}
	public String getExpiration_date() {
		return expiration_date;
	}
	public void setExpiration_date(String expiration_date) {
		this.expiration_date = expiration_date;
	}
	
	
	


}
