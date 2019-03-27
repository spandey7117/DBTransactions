package com.DBTransactions;


import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.ServerAddress;
import com.mongodb.MongoCredential;
import com.mongodb.MongoClientOptions;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import com.mongodb.client.MongoCollection;
import java.util.Arrays;

public class Insert {

	public Response insertInMongo(UserDetails userDetails, MongoClient mongoClient) {
		Response res = new Response();
		try {
			// MongoClient mongoClient = new MongoClient(new
			// MongoClientURI("mongodb://admin:admin@cluster0-shard-00-00-2nifw.mongodb.net:27017,cluster0-shard-00-01-2nifw.mongodb.net:27017,cluster0-shard-00-02-2nifw.mongodb.net:27017/test?ssl=true&replicaSet=Cluster0-shard-0&authSource=admin&retryWrites=true"));
			// System.out.println("Connected Successfully");
			MongoDatabase database = mongoClient.getDatabase("myNewDB");
			// database.createCollection("sampleCollection1");
			// System.out.println("Collection created successfully");
			MongoCollection<Document> collection = database.getCollection("sampleCollection");
			System.out.println("Collection sampleCollection selected successfully");

			Document document = new Document("name", userDetails.name).append("sex", userDetails.sex)
					.append("phoneNumber", userDetails.phoneNumber).append("emailID", userDetails.emailID)
					.append("age", userDetails.age).append("status", "Pending").append("password", userDetails.password);
			collection.insertOne(document);
			System.out.println("Document inserted successfully");
			res.setResponseCode("200");
			res.setResponseMessage("Inserted Successfully");
			
			return res;
		} catch (Exception e) {
			e.printStackTrace();
			res.setResponseCode("0");
			res.setResponseMessage("Internal Exception");
			return res;

		}

	}
	
	
	public Response insertInMongoDetailsLoc(UserDetailWithLocation userDetails, MongoClient mongoClient) {
		Response res = new Response();
		try {
			// MongoClient mongoClient = new MongoClient(new
			// MongoClientURI("mongodb://admin:admin@cluster0-shard-00-00-2nifw.mongodb.net:27017,cluster0-shard-00-01-2nifw.mongodb.net:27017,cluster0-shard-00-02-2nifw.mongodb.net:27017/test?ssl=true&replicaSet=Cluster0-shard-0&authSource=admin&retryWrites=true"));
			// System.out.println("Connected Successfully");
			MongoDatabase database = mongoClient.getDatabase("myNewDB");
			// database.createCollection("sampleCollection1");
			// System.out.println("Collection created successfully");
			MongoCollection<Document> collection = database.getCollection("sampleCollection2");
			System.out.println("Collection sampleCollection selected successfully");

			Document document = new Document("endLatitude", userDetails.endLatitude).append("endLongitude", userDetails.endLongitude)
					.append("id", userDetails.id)
					.append("startLatitude", userDetails.startLatitude).append("status", "Pending").append("startLongitude", userDetails.startLongitude).append("preferedSex", userDetails.preferedSex).append("preferedMode", userDetails.preferedMode);
			collection.insertOne(document);
			System.out.println("Document inserted successfully");
			res.setResponseCode("200");
			res.setResponseMessage("Inserted Successfully");
			
			return res;
		} catch (Exception e) {
			e.printStackTrace();
			res.setResponseCode("0");
			res.setResponseMessage("Internal Exception");
			return res;

		}

	}
	public Response insertInMongoDBMyPlan(MyPlan myPlan, MongoClient mongoClient) {
		Response res = new Response();
		try {
			// MongoClient mongoClient = new MongoClient(new
			// MongoClientURI("mongodb://admin:admin@cluster0-shard-00-00-2nifw.mongodb.net:27017,cluster0-shard-00-01-2nifw.mongodb.net:27017,cluster0-shard-00-02-2nifw.mongodb.net:27017/test?ssl=true&replicaSet=Cluster0-shard-0&authSource=admin&retryWrites=true"));
			// System.out.println("Connected Successfully");
			MongoDatabase database = mongoClient.getDatabase("myNewDB");
			// database.createCollection("sampleCollection1");
			// System.out.println("Collection created successfully");
			MongoCollection<Document> collection = database.getCollection("sampleCollection2");
			System.out.println("Collection sampleCollection selected successfully");

			Document document = new Document("endLatitude", myPlan.endLat).append("endLongitude", myPlan.endLong).append("myPlanName", myPlan.myPlanName)
					.append("id", myPlan.id)
					.append("startLatitude", myPlan.startLat).append("status", "Pending").append("startLongitude", myPlan.startLong).append("time", myPlan.time).append("preferedMode", myPlan.preferedMode).append("preferedSex", myPlan.preferedSex).append("type", "MyPlan").append("startLoc", myPlan.startLoc).append("endLoc", myPlan.endLoc);
			collection.insertOne(document);
			System.out.println("Document inserted successfully");
			res.setResponseCode("200");
			res.setResponseMessage("Inserted Successfully");
			
			return res;
		} catch (Exception e) {
			e.printStackTrace();
			res.setResponseCode("0");
			res.setResponseMessage("Internal Exception");
			return res;

		}

	}

}
