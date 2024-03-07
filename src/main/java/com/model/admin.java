package com.model;

//Hi this is the second commit
public class admin {
	
	private int id;
	private String name;
	private String email;
	private String phone;
	private String username;
	private String password;
	private String category;
	private byte[] adminImage;

	
	public admin(int id, String name, String email, String phone, String username, String password, String category)
	{
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.username = username;
		this.password = password;	
		this.category = category;
	}
	public admin( String name, String email, String phone, String username, String password,byte[] adminImage, String category)
	{
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.username = username;
		this.password = password;
		this.adminImage = adminImage;
		this.category = category;

	}
	public admin(int id, String name, String email, String phone, String username, String password,byte[] adminImage,String category)
	{
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.username = username;
		this.password = password;
		this.adminImage =adminImage;
		this.category = category;

	
	}
	//getters
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public String getPhone() {
		return phone;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public byte[] getadminImage() {
		return adminImage;
	}
	public String getcategory() {
		return category;
	}
	public void setName(String name) {
        this.name = name;
    }
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password =password;
	}
	public void setAdminImage(byte[] adminImage) {
	    this.adminImage = adminImage;
	}
	public void setCategory(String category) {
	    this.category = category;
	}

}
