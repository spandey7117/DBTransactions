package com.DBTransactions;

import java.util.Iterator;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;

public class Update {
	public Response updatePasswordByemailID(LoginInput li, MongoClient mongoClient) {
		Response res = new Response();
		try {

			MongoDatabase database = mongoClient.getDatabase("myNewDB");
			MongoCollection<Document> collection = database.getCollection("sampleCollection");
			System.out.println("Collection sampleCollection selected successfully");
				collection.updateOne(Filters.eq("emailID", li.emailID), Updates.set("password", li.Password));

			// Getting the iterator
		
				System.out.println( li.emailID+ " User Valid");
				res.setResponseCode("200");
				res.setResponseMessage("UpdatedSuccessfull");
			
			return res;
		} catch (Exception e) {
			e.printStackTrace();
			res.setResponseCode("0");
			res.setResponseMessage("InternalError");
			return res;
		}
	}
}
