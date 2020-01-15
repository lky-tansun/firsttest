package com.example.sqlite;

public class User {
	private String username;
	private String sex;
	private String birthday;
	private String place;
	private String email;
	private String password;
	private int isDel;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getsex() {
		return sex;
	}
	public void setsex(String sex) {
		this.sex= sex;
	}
	public String getbirthday() {
		return birthday;
	}
	public void setbirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getplace() {
		return place;
	}
	public void setplace(String place) {
		this.place = place;
	}
	public String getemail() {
		return email;
	}
	public void setemail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getIsDel() {
		return isDel;
	}
	public void setIsDel(int isDel) {
		this.isDel = isDel;
	}
	
}
