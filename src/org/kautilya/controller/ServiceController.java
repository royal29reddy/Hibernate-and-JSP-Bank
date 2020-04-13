package org.kautilya.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.kautilya.entity.Transaction;
import org.kautilya.entity.Users;
import org.kautiya.model.TransactionModel;
import org.kautiya.model.UsersModel;

/**
 * Servlet implementation class ServiceController
 */
@WebServlet("/service")
public class ServiceController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		operations(request,response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
	
	private void operations(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		String username=request.getParameter("username");
		String operation="";
		switch(action) {
		case "send":
			operation="send";
			request.setAttribute("operation", operation);
			request.setAttribute("username", username);
			request.getRequestDispatcher("pay.jsp").forward(request, response);
			break;
		case "request":
			operation="request";
			request.setAttribute("operation", operation);
			request.setAttribute("username", username);
			request.getRequestDispatcher("pay.jsp").forward(request, response);
			break;
		case "deposit":
			operation="deposit";
			request.setAttribute("operation", operation);
			request.setAttribute("username", username);
			request.getRequestDispatcher("pay.jsp").forward(request, response);
			break;
		case "balance":
			viewBalance(request,response);
			break;
		case "profile":
			viewProfile(request,response);
			break;
		}
		
	}



	private void viewBalance(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operation="balance";
		request.setAttribute("operation", operation);
		String username=request.getParameter("username");
		List<Transaction> users = new TransactionModel().listUsers(username);
		request.setAttribute("users", users);
		request.getRequestDispatcher("balance.jsp?username="+username).forward(request, response);
		
	}
	
	private void viewProfile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operation="profile";
		request.setAttribute("operation", operation);
		String username=request.getParameter("username");
		List<Users> users = new UsersModel().listUsers();
		request.setAttribute("users", users);
		for(Users user:users) {
			if(username.equals(user.getUserName())) {
				request.setAttribute("accountNumber", user.getaccount_number());
				request.getRequestDispatcher("profile.jsp").forward(request, response);
			}
		}
		
		
	}


}
