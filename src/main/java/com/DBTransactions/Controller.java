package com.DBTransactions;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.geometry.S2LatLng;
import com.google.common.geometry.S2Point;
import com.mongodb.MongoClient;

@RestController
public class Controller {
	Insert ins = new Insert();
	Find find = new Find();
	Update up = new Update();
	ConnectionManager cm = new ConnectionManager();

	@RequestMapping("/InsertDataEntry")
	public Response userDetailsEntry(@RequestParam(value = "phoneNumber") String phoneNumber,
			@RequestParam(value = "name", defaultValue = "shbham") String name, @RequestParam(value = "emailID") String emailID,
			@RequestParam(value = "sex") String sex, @RequestParam(value = "age") String age, @RequestParam(value = "password") String password) {
		Response res = new Response();
		MongoClient mongoClient = cm.createConnection();
		try {

		
			UserDetails userDetails = new UserDetails(name, phoneNumber, emailID, age, sex,password);
			res = find.findInDBPhoneNumber(userDetails, mongoClient);
			System.out.println("responsecode returned in findNumber: " + res.getResponseCode());
			if (res.getResponseCode().equals("1001")) {
				res = find.findInDBEmailID(userDetails, mongoClient);
				System.out.println("responsecode returned in findEmail ID: " + res.getResponseCode());
				if (res.getResponseCode().equals("1002")) {
					res = ins.insertInMongo(userDetails, mongoClient);
					System.out.println("responsecode returned in InsertDetails: " + res.getResponseCode());
					if (res.getResponseCode().equals("200"))
						
					{
						System.out.println("Inserted Susscessfully");
					}
				}
			}
			
			mongoClient.close();
			return res;
		} catch (Exception e) {
			System.out.println("Error In controller");
			e.printStackTrace();
			res.setResponseCode("0");
			res.setResponseMessage("Internal Exception occured");
			mongoClient.close();
			return res;
		}
	}
	@RequestMapping("/Login")
	public Response login( @RequestParam(value = "emailID") String emailID,
			 @RequestParam(value = "password") String password) {
		Response res = new Response();
		MongoClient mongoClient = cm.createConnection();
		try {

			
		LoginInput li = new LoginInput(emailID, password);
			//res = find.findInDBEmailIDAndPassword(li, mongoClient);
		res = find.findInDBEmailIDAndPasswordActive(li, mongoClient);
			System.out.println("responsecode returned in findNumber: " + res.getResponseCode());
			if (res.getResponseCode().equals("200")) {
				System.out.println("User Validated Succesfully");
			}
			else
			{
				System.out.println("User Not Validated ");
			}
			mongoClient.close();
			return res;
		} catch (Exception e) {
			System.out.println("Error In controller");
			e.printStackTrace();
			res.setResponseCode("0");
			res.setResponseMessage("Internal Exception occured");
			mongoClient.close();
			return res;
		}
	}
	
	@RequestMapping("/UpdatePassword")
	public Response updatePassword( @RequestParam(value = "emailID") String emailID,
			 @RequestParam(value = "password") String password) {
		Response res = new Response();
		MongoClient mongoClient = cm.createConnection();
		try {

			
		LoginInput li = new LoginInput(emailID, password);
			res = up.updatePasswordByemailID(li, mongoClient);
			System.out.println("responsecode returned in findNumber: " + res.getResponseCode());
			if (res.getResponseCode().equals("200")) {
				System.out.println("Password updated Succesfully");
			}
			else
			{
				System.out.println("Password Not Updated Validated ");
			}
			mongoClient.close();
			return res;
		} catch (Exception e) {
			System.out.println("Error In controller");
			e.printStackTrace();
			res.setResponseCode("0");
			res.setResponseMessage("Internal Exception occured");
			mongoClient.close();
			return res;
		}
	}
	@RequestMapping("/UpdateAll")
	public Response updateAll(@RequestParam(value = "phoneNumber") String phoneNumber,
			@RequestParam(value = "name") String name, @RequestParam(value = "emailID") String emailID,
			@RequestParam(value = "sex") String sex, @RequestParam(value = "age") String age) {
		Response res = new Response();
		MongoClient mongoClient = cm.createConnection();
		try {

			

			UserDetails userDetails = new UserDetails(name, phoneNumber, emailID, age, sex,"password");
			res = up.updateAllByemailID(userDetails, mongoClient);
			System.out.println("responsecode returned in findNumber: " + res.getResponseCode());
			if (res.getResponseCode().equals("200")) {
				System.out.println("Password updated Succesfully");
			}
			else
			{
				System.out.println("Password Not Updated Validated ");
			}
			mongoClient.close();
			return res;
		} catch (Exception e) {
			System.out.println("Error In controller");
			e.printStackTrace();
			res.setResponseCode("0");
			res.setResponseMessage("Internal Exception occured");
			mongoClient.close();
			return res;
		}
	}
	
	@RequestMapping("/UpdateStatus")
	public Response updateStatus(@RequestParam(value = "emailID") String emailID) {
		Response res = new Response();
		MongoClient mongoClient = cm.createConnection();
		try {

			
			OTPUpdateInput oTPUpdateInput = new OTPUpdateInput(emailID);
			res = up.updateStatusByemailID(oTPUpdateInput, mongoClient);
			System.out.println("responsecode returned in findNumber: " + res.getResponseCode());
			if (res.getResponseCode().equals("200")) {
				System.out.println("Status updated Succesfully");
			}
			else
			{
				System.out.println("Status Not Updated ");
			}
			mongoClient.close();
			return res;
		} catch (Exception e) {
			System.out.println("Error In controller");
			e.printStackTrace();
			res.setResponseCode("0");
			res.setResponseMessage("Internal Exception occured");
			mongoClient.close();
			return res;
		}
	}
	
	@RequestMapping("/InsertLocData")
	public Response userDetailsEntry(@RequestParam(value = "startLat") String startLat,
			@RequestParam(value = "endLat" ) String endLat, @RequestParam(value = "endLong") String endLong,@RequestParam(value = "startLong") String startLong, @RequestParam(value = "id") String id) 
			 {
		Response res = new Response();
		MongoClient mongoClient = cm.createConnection();
		try {

			
			S2Point startPoint = S2LatLng.fromDegrees(Double.parseDouble(startLat), Double.parseDouble(startLong)).toPoint();
			S2Point endPoint = S2LatLng.fromDegrees(Double.parseDouble(endLat), Double.parseDouble(endLong)).toPoint();
			UserDetailWithLocation userDetails = new UserDetailWithLocation(startPoint, endPoint, id, "Pending", Double.parseDouble(startLong), Double.parseDouble(startLat), Double.parseDouble(endLong), Double.parseDouble(endLat));
			res = ins.insertInMongoDetailsLoc(userDetails, mongoClient);
			System.out.println("responsecode returned in findNumber: " + res.getResponseCode());
			if (res.getResponseCode().equals("200"))
						
					{
						System.out.println("Inserted Susscessfully");
						mongoClient.close();
			return res;
		}
		}catch (Exception e) {
			System.out.println("Error In controller");
			e.printStackTrace();
			res.setResponseCode("0");
			res.setResponseMessage("Internal Exception occured");
			mongoClient.close();
			return res;
		}
		
		
		mongoClient.close();
		
		return res;
		
}
	
	@RequestMapping("/InsertMyPlan")
	public Response userDetailsEntryForPlan(@RequestParam(value = "startLat") String startLat,@RequestParam(value = "name") String name,@RequestParam(value = "startLoc") String startLoc,@RequestParam(value = "endLoc") String endLoc,
			@RequestParam(value = "endLat" ) String endLat, @RequestParam(value = "endLong") String endLong,@RequestParam(value = "startLong") String startLong, @RequestParam(value = "id") String id,@RequestParam(value = "time") String time,@RequestParam(value = "preferedMode") String preferedMode,@RequestParam(value = "preferedSex") String preferedSex) 
			 {
		Response res = new Response();
		MongoClient mongoClient = cm.createConnection();
		try {

			MyPlan myPlan= new MyPlan(id, time, startLong, startLat, endLong, endLat, preferedMode, preferedSex,name,startLoc,endLoc);
			res = ins.insertInMongoDBMyPlan(myPlan, mongoClient);
			System.out.println("responsecode returned in findNumber: " + res.getResponseCode());
			if (res.getResponseCode().equals("200"))
						
					{
						System.out.println("Inserted Susscessfully");
						mongoClient.close();
			return res;
		}
		}catch (Exception e) {
			System.out.println("Error In controller");
			e.printStackTrace();
			res.setResponseCode("0");
			res.setResponseMessage("Internal Exception occured");
			mongoClient.close();
			return res;
		}
		
		
		mongoClient.close();
		
		return res;
		
}
	
	
	@RequestMapping("/FindMyPlan")
	public ResMyPlan findMyPlan(@RequestParam(value = "id") String id ) {
		ResMyPlan res = new ResMyPlan();
		MongoClient mongoClient = cm.createConnection();
		try {

			res = find.findMyPlanInDBEmailID(id, mongoClient);
			System.out.println("responsecode returned in findNumber: " + res.getResponseCode());
			if (res.getResponseCode().equals("200"))
						
					{
						System.out.println("Retrieved Susscessfully");
						mongoClient.close();
			return res;
		}
		}catch (Exception e) {
			System.out.println("Error In controller");
			e.printStackTrace();
			res.setResponseCode("0");
			res.setResponseMessage("Internal Exception occured");
			mongoClient.close();
			return res;
		}
		
		
		mongoClient.close();
		
		return res;
		
}
	
	
	
	@RequestMapping("/check")
	public String check() {
	String hello="hello";
		try {

			
			
			return hello;
		}
		catch (Exception e) {
			System.out.println("Error In controller");
			e.printStackTrace();
			
			return hello;
		}
		
}
	
	
	
}