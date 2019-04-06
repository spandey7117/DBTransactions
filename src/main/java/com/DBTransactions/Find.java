package com.DBTransactions;


import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.ServerAddress;
import com.mongodb.MongoCredential;
import com.mongodb.MongoClientOptions;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Find {

	public Response findInDBPhoneNumber(UserDetails userDetails, MongoClient mongoClient) {
		Response res = new Response();
		try {
			// MongoClient mongoClient = new MongoClient(new
			// MongoClientURI("mongodb://admin:admin@cluster0-shard-00-00-2nifw.mongodb.net:27017,cluster0-shard-00-01-2nifw.mongodb.net:27017,cluster0-shard-00-02-2nifw.mongodb.net:27017/test?ssl=true&replicaSet=Cluster0-shard-0&authSource=admin&retryWrites=true"));
			// System.out.println("Connected Successfully");
			MongoDatabase database = mongoClient.getDatabase("myNewDB");
			MongoCollection<Document> collection = database.getCollection("UsersCollection");
			System.out.println("Collection UsersCollection selected successfully");

			FindIterable<Document> iterDoc = collection.find(Filters.eq("phoneNumber", userDetails.phoneNumber));

			// Getting the iterator
			Iterator it = iterDoc.iterator();

			if (it.hasNext()) {
				System.out.println(userDetails.getPhoneNumber() + " Phone Number already exists");
				res.setResponseCode("1");
				res.setResponseMessage("NumberAlreadyExists");
			} else {
				System.out.println(userDetails.getPhoneNumber() + " number does not exists in db");
				res.setResponseCode("1001");
				res.setResponseMessage("NumberDoesNotExistsInDB");
			}
			
			return res;
		} catch (Exception e) {
			e.printStackTrace();
			res.setResponseCode("0");
			res.setResponseMessage("InternalError");
			return res;
		}
	}

	public Response findInDBEmailID(UserDetails userDetails, MongoClient mongoClient) {
		Response res = new Response();
		try {

			MongoDatabase database = mongoClient.getDatabase("myNewDB");
			MongoCollection<Document> collection = database.getCollection("UsersCollection");
			System.out.println("Collection UsersCollection selected successfully");

			FindIterable<Document> iterDoc = collection.find(Filters.eq("emailID", userDetails.emailID));

			// Getting the iterator
			Iterator it = iterDoc.iterator();

			if (it.hasNext()) {
				System.out.println( userDetails.emailID+ " email already exists");
				res.setResponseCode("101");
				res.setResponseMessage("EmailIDAlreadyExists");
			} else {
				System.out.println( userDetails.emailID + " email does not exists in db");
				res.setResponseCode("1002");
				res.setResponseMessage("emailIDDoesNotExistsInDB");
			}
			
			return res;
		} catch (Exception e) {
			e.printStackTrace();
			res.setResponseCode("0");
			res.setResponseMessage("InternalError");
			return res;
		}
	}

	public Response findInDBEmailID2(String id, MongoClient mongoClient) {
		Response res = new Response();
		try {

			MongoDatabase database = mongoClient.getDatabase("myNewDB");
			MongoCollection<Document> collection = database.getCollection("ASE_TestCollection");
			System.out.println("Collection UsersCollection selected successfully");

			FindIterable<Document> iterDoc = collection.find(Filters.eq("id", id));

			// Getting the iterator
			Iterator it = iterDoc.iterator();

			if (it.hasNext()) {
				System.out.println( id+ " email already exists");
				res.setResponseCode("101");
				res.setResponseMessage("EmailIDAlreadyExists");
			} else {
				System.out.println( id + " email does not exists in db");
				res.setResponseCode("1002");
				res.setResponseMessage("emailIDDoesNotExistsInDB");
			}
			
			return res;
		} catch (Exception e) {
			e.printStackTrace();
			res.setResponseCode("0");
			res.setResponseMessage("InternalError");
			return res;
		}
	}
	
	public Response findInDBEmailIDAndPassword(LoginInput li, MongoClient mongoClient) {
		Response res = new Response();
		try {

			MongoDatabase database = mongoClient.getDatabase("myNewDB");
			MongoCollection<Document> collection = database.getCollection("ASE_TestCollection");
			System.out.println("Collection sampleCollection selected successfully");
			BasicDBObject query = new BasicDBObject();
			
			query.put("id", li.getEmailID());
			query.put("status", "MyPlan");
			
			FindIterable<Document> iterDoc = collection.find( query);

			// Getting the iterator
			Iterator it = iterDoc.iterator();

			if (it.hasNext()) {
				System.out.println( li.emailID+ " User Valid");
				res.setResponseCode("200");
				res.setResponseMessage("ValidateSuccessfull");
			} else {
				System.out.println( li.emailID + " User Invailde");
				res.setResponseCode("105");
				res.setResponseMessage("ValidateUnsuccessfull");
			}
		
			return res;
		} catch (Exception e) {
			e.printStackTrace();
			res.setResponseCode("0");
			res.setResponseMessage("InternalError");
			return res;
		}
	}
	
	public Response findInDBEmailIDAndPasswordActive(LoginInput li, MongoClient mongoClient) {
		Response res = new Response();
		try {

			MongoDatabase database = mongoClient.getDatabase("myNewDB");
			MongoCollection<Document> collection = database.getCollection("UsersCollection");
			System.out.println("Collection UsersCollection selected successfully");
			BasicDBObject query = new BasicDBObject();
			
			query.put("emailID", li.getEmailID());
			query.put("password", li.getPassword());

			
			FindIterable<Document> iterDoc = collection.find( query);

			// Getting the iterator
			Iterator it = iterDoc.iterator();

			if (it.hasNext()) {
				if(it.next().toString().contains("Active")) {
				System.out.println( li.emailID+ " User Valid");
				res.setResponseCode("200");
				res.setResponseMessage("ValidateSuccessfull");}
				else
				{
					System.out.println( li.emailID+ " User Valid");
					res.setResponseCode("500");
					res.setResponseMessage("IDNotValid");
				}
			} else {
				System.out.println( li.emailID + " User Invailde");
				res.setResponseCode("105");
				res.setResponseMessage("ValidateUnsuccessfull");
			}
			
			return res;
		} catch (Exception e) {
			e.printStackTrace();
			res.setResponseCode("0");
			res.setResponseMessage("InternalError");
			return res;
		}
	}
	
	
	public ResMyPlan findMyPlanInDBEmailID(String id, MongoClient mongoClient) {
		ResMyPlan res = new ResMyPlan();
		try {

			MongoDatabase database = mongoClient.getDatabase("myNewDB");
			MongoCollection<Document> collection = database.getCollection("ASE_TestCollection");
			System.out.println("Collection ASE_TestCollection selected successfully");
			BasicDBObject query = new BasicDBObject();
			
			query.put("id", id);
			query.put("type", "MyPlan");
			query.put("status", "Pending");

			
			FindIterable<Document> iterDoc = collection.find( query);

			Iterator it = iterDoc.iterator();

			if (it.hasNext()) {
				System.out.println("User PlanPresent");
				res.setResponseCode("200");
				res.setResponseMessage("PlanPresent");

			} else {
				res.setResponseCode("100");
				res.setResponseMessage("NoPlan");
				System.out.println("User No PlanPresent");
			}
int count=0;
			it = iterDoc.iterator();
			while (it.hasNext()) {
				it.next();
			count++;
			}
			Helper helper= new Helper();
			MyPlan[] myplans=new MyPlan[count];
			it = iterDoc.iterator();
			count=0;
			while (it.hasNext()) {
				MyPlan myp=new MyPlan();
				
				String sos=it.next().toString();
				System.out.println(sos);
				myp=helper.myplanConerter(sos);
				myplans[count]=myp;
				count++;
				
			}
			res.setMyplans(myplans);
			return res;
		} catch (Exception e) {
			e.printStackTrace();
			res.setResponseCode("0");
			res.setResponseMessage("InternalError");
			return res;
		}
	}
	
	
	public UserDetails findInDBByEmailID(String id, MongoClient mongoClient) {
		UserDetails user = new UserDetails();
		try {

			MongoDatabase database = mongoClient.getDatabase("myNewDB");
			MongoCollection<Document> collection = database.getCollection("UsersCollection");
			System.out.println("Collection ASE_TestCollection selected successfully");

			FindIterable<Document> iterDoc = collection.find(Filters.eq("emailID",id));
			UserParser userParser= new UserParser();
			// Getting the iterator
			Iterator it = iterDoc.iterator();

			if (it.hasNext()) {
				System.out.println( id+ " email  exists");
				user= userParser.parser(it.next().toString());
			} else {
				System.out.println( id + " email does not exists in db sampleCollection");
				
			}
			
			return user;
		} catch (Exception e) {
			e.printStackTrace();
			
			return user;
		}
	}
}
