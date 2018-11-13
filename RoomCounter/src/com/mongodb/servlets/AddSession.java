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
import com.mongodb.client.MongoDatabase;

import com.mongodb.DBInterface.*;

@WebServlet("/addSession")
public class AddSession extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws
			ServletException, IOException {
			
		 String sessionName = request.getParameter("session-name");
		 String sessionID = request.getParameter("session-number");
		 String speakerName = request.getParameter("speaker");

		 
		if(sessionName == null || sessionID == null || speakerName == null) {
			//error
			System.out.println("Error adding, values null");
			RequestDispatcher rd = getServletContext().getRequestDispatcher(
					"/Creation Menu.jsp");
			rd.forward(request, response);
		}else {
			MongoClient mongo = (MongoClient) request.getServletContext()
					.getAttribute("MONGO_CLIENT");
			
			//Test prints -- This would be where we do verification and adding to db
			System.out.println(sessionName);
			System.out.println(sessionID);
			System.out.println(speakerName);
			
			
	        
	        Database_Init_Interface dbi = new Database_Init_Interface();
	        dbi.pushSessionDocument(sessionName, sessionID, speakerName, "", "");
	        

			
			
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/Creation Menu.jsp");
			rd.forward(request, response);
			
		}
		
	
	}

}
