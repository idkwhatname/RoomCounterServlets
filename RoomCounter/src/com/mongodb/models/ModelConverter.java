package com.mongodb.models;

import org.bson.types.ObjectId;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;

public class ModelConverter {
	
	public static Room toRoom(DBObject doc) {
		Room r = new Room();
		r.setName((String)doc.get("name"));
		r.setCapacity((String) doc.get("capacity"));
		return r;
	}

}
