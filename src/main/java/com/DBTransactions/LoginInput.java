package com.DBTransactions;

public class LoginInput {
String emailID;
String Password;
public String getEmailID() {
	return emailID;
}
public void setEmailID(String emailID) {
	this.emailID = emailID;
}
public String getPassword() {
	return Password;
}
public void setPassword(String password) {
	Password = password;
}
public LoginInput(String emailID, String password) {
	super();
	this.emailID = emailID;
	Password = password;
}

}
