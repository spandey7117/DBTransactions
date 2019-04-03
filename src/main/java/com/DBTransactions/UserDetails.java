package com.DBTransactions;

public class UserDetails {
	String name;
	String phoneNumber;
	String emailID;
	String age;
	String sex;
	String password;
	String rating;
	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public UserDetails() {
	}
	public UserDetails(String name, String phoneNumber, String emailID, String age, String sex, String password, String rating) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.emailID = emailID;
		this.age = age;
		this.sex = sex;
		this.password = password;
		this.rating = rating;
	}
	

}
