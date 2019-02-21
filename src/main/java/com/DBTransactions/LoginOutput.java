package com.DBTransactions;

public class LoginOutput {

	String ResponseCode;
	String ResponseMessage;
	String emailID;
	public String getResponseCode() {
		return ResponseCode;
	}
	public void setResponseCode(String responseCode) {
		ResponseCode = responseCode;
	}
	public String getResponseMessage() {
		return ResponseMessage;
	}
	public void setResponseMessage(String responseMessage) {
		ResponseMessage = responseMessage;
	}
	public String getEmailID() {
		return emailID;
	}
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
	public LoginOutput(String responseCode, String responseMessage, String emailID) {
		super();
		ResponseCode = responseCode;
		ResponseMessage = responseMessage;
		this.emailID = emailID;
	}
	
	
}
