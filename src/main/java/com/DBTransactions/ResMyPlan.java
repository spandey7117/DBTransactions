package com.DBTransactions;

public class ResMyPlan {
	String ResponseCode;
	String ResponseMessage;
	MyPlan[] myplans;
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
	public MyPlan[] getMyplans() {
		return myplans;
	}
	public void setMyplans(MyPlan[] myplans) {
		this.myplans = myplans;
	}
	
	
}
