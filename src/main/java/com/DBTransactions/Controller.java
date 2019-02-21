package com.DBTransactions;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.mongodb.MongoClient;

@RestController
public class Controller {
	Insert ins = new Insert();
	Find find = new Find();
	Update up = new Update();
	ConnectionManager cm = new ConnectionManager();

	@RequestMapping("/InsertDataEntry")
	public Response userDetailsEntry(@RequestParam(value = "phoneNumber") String phoneNumber,
			@RequestParam(value = "name") String name, @RequestParam(value = "emailID") String emailID,
			@RequestParam(value = "sex") String sex, @RequestParam(value = "age") String age, @RequestParam(value = "password") String password) {
		Response res = new Response();
		try {

			MongoClient mongoClient = cm.createConnection();
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
			return res;
		} catch (Exception e) {
			System.out.println("Error In controller");
			e.printStackTrace();
			res.setResponseCode("0");
			res.setResponseMessage("Internal Exception occured");
			return res;
		}
	}
	@RequestMapping("/Login")
	public Response login( @RequestParam(value = "emailID") String emailID,
			 @RequestParam(value = "password") String password) {
		Response res = new Response();
		try {

			MongoClient mongoClient = cm.createConnection();
		LoginInput li = new LoginInput(emailID, password);
			res = find.findInDBEmailIDAndPassword(li, mongoClient);
			System.out.println("responsecode returned in findNumber: " + res.getResponseCode());
			if (res.getResponseCode().equals("200")) {
				System.out.println("User Validated Succesfully");
			}
			else
			{
				System.out.println("User Not Validated ");
			}
			return res;
		} catch (Exception e) {
			System.out.println("Error In controller");
			e.printStackTrace();
			res.setResponseCode("0");
			res.setResponseMessage("Internal Exception occured");
			return res;
		}
	}
	
	@RequestMapping("/UpdatePassword")
	public Response updatePassword( @RequestParam(value = "emailID") String emailID,
			 @RequestParam(value = "password") String password) {
		Response res = new Response();
		try {

			MongoClient mongoClient = cm.createConnection();
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
			return res;
		} catch (Exception e) {
			System.out.println("Error In controller");
			e.printStackTrace();
			res.setResponseCode("0");
			res.setResponseMessage("Internal Exception occured");
			return res;
		}
	}
	
}