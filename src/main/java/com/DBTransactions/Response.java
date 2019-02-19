package com.DBTransactions;

public class Response {
String ResponseCode;
String ResponseMessage;
public Response(String responseCode, String responseMessage) {
	super();
	ResponseCode = responseCode;
	ResponseMessage = responseMessage;
}
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
public Response() {
	
}


}
