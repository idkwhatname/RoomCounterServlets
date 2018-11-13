package com.mongodb.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bson.Document;

import com.mongodb.*;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.DBObject;
import com.mongodb.DBCursor;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.models.Room;
import com.mongodb.models.ModelConverter;

import com.mongodb.DBInterface.*;

@WebServlet("/addRoomSlot")
public class AddRoom extends HttpServlet {
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws
			ServletException, IOException {
			
		 String roomName = request.getParameter("room-name");
		 String capacity = request.getParameter("capacity");

		 
		if(roomName == null || capacity == null) {
			//error
			System.out.println("Error adding, values null");
			RequestDispatcher rd = getServletContext().getRequestDispatcher(
					"/Creation Menu.jsp");
			rd.forward(request, response);
		}else {
			MongoClient mongo = (MongoClient) request.getServletContext()
					.getAttribute("MONGO_CLIENT");
			
			//Test prints -- This would be where we do verification and adding to db
			System.out.println(roomName);
			System.out.println(capacity);
			
			
			Database_Init_Interface dbi = new Database_Init_Interface();
			dbi.pushRoomDocument(roomName,"0", capacity);
			
			
			
			
			
			//List logic
			
			/*
			List<Room> data = new ArrayList<Room>();
			DBCursor cursor = col.find();
			while(cursor.hasNext()) {
				DBObject doc = (DBObject) cursor.next();
				Room r = ModelConverter.toRoom(doc);
				data.add(r);
			}
			*/
			
			
			//DUMMY DATA
			List<Room> data2 = new ArrayList<Room>();
			Room r1 = new Room();
			r1.setName("Room 1");
			r1.setCapacity("24");
			
			
			
			request.setAttribute("rooms", data2);
			
			
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/Creation Menu.jsp");
			rd.forward(request, response);
			
		}
		
	
	}

}
