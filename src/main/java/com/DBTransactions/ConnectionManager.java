package com.DBTransactions;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

public class ConnectionManager {
	private final String URL = "mongodb://admin:admin@cluster0-shard-00-00-2nifw.mongodb.net:27017,cluster0-shard-00-01-2nifw.mongodb.net:27017,cluster0-shard-00-02-2nifw.mongodb.net:27017/test?ssl=true&replicaSet=Cluster0-shard-0&authSource=admin&retryWrites=true";

	public MongoClient createConnection() {
		MongoClient mongoClient = new MongoClient(new MongoClientURI(URL));
		System.out.println("Connected Successfully");
		return mongoClient;
	}

}