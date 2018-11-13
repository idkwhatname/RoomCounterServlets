package com.mongodb.servlets;

import java.io.IOException;
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
import com.mongodb.client.MongoDatabase;

import com.mongodb.DBInterface.*;

@WebServlet("/addTimeSlot")
public class AddTime extends HttpServlet {
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws
			ServletException, IOException {
			
		 String startTime = request.getParameter("start");
		 String endTime = request.getParameter("end");

		 
		if(startTime == null || endTime == null) {
			//error
			System.out.println("Error adding, values null");
			RequestDispatcher rd = getServletContext().getRequestDispatcher(
					"/Creation Menu.jsp");
			rd.forward(request, response);
		}else {
			MongoClient mongo = (MongoClient) request.getServletContext()
					.getAttribute("MONGO_CLIENT");
			
			//Adding to db
			
			Database_Init_Interface dbi = new Database_Init_Interface();
			dbi.pushTimeslotDocument("0", startTime, endTime);
			
			
			//Test prints -- This would be where we do verification and adding to db
			System.out.println(startTime);
			System.out.println(endTime);
			
			
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/Creation Menu.jsp");
			rd.forward(request, response);
			
		}
		
	
	}

}
