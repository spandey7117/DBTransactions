package com.DBTransactions;

public class MyPlan {

	String id;
	String time;
	String startLong;
	String startLat;
	String endLong;
	String endLat;
	String preferedMode;
	String preferedSex;
	String myPlanName;
	String startLoc;
	String endLoc;
	
	public String getStartLoc() {
		return startLoc;
	}
	public void setStartLoc(String startLoc) {
		this.startLoc = startLoc;
	}
	public String getEndLoc() {
		return endLoc;
	}
	public void setEndLoc(String endLoc) {
		this.endLoc = endLoc;
	}
	public String getMyPlanName() {
		return myPlanName;
	}
	public void setMyPlanName(String myPlanName) {
		this.myPlanName = myPlanName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getStartLong() {
		return startLong;
	}
	public void setStartLong(String startLong) {
		this.startLong = startLong;
	}
	public String getStartLat() {
		return startLat;
	}
	public void setStartLat(String startLat) {
		this.startLat = startLat;
	}
	public String getEndLong() {
		return endLong;
	}
	public void setEndLong(String endLong) {
		this.endLong = endLong;
	}
	public String getEndLat() {
		return endLat;
	}
	public void setEndLat(String endLat) {
		this.endLat = endLat;
	}
	public String getPreferedMode() {
		return preferedMode;
	}
	public void setPreferedMode(String preferedMode) {
		this.preferedMode = preferedMode;
	}
	public String getPreferedSex() {
		return preferedSex;
	}
	public void setPreferedSex(String preferedSex) {
		this.preferedSex = preferedSex;
	}
	public MyPlan(String id, String time, String startLong, String startLat, String endLong, String endLat,
			String preferedMode, String preferedSex, String myPlanName, String startLoc, String endLoc) {
		super();
		this.id = id;
		this.time = time;
		this.startLong = startLong;
		this.startLat = startLat;
		this.endLong = endLong;
		this.endLat = endLat;
		this.preferedMode = preferedMode;
		this.preferedSex = preferedSex;
		this.myPlanName=myPlanName;
		this.startLoc=startLoc;
		this.endLoc=endLoc;
	}
	public MyPlan() {}
	
	
}
