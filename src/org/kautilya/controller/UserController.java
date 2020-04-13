package org.kautilya.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.kautilya.entity.Transaction;
import org.kautilya.entity.Users;
import org.kautiya.model.TransactionModel;
import org.kautiya.model.UsersModel;



@WebServlet("/user")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("signup.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");

		switch(action) {
		case "signup":
			signup(request,response);
			break;
			
		case "login":
			login(request,response);
			break;
		
		default:
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		List<Users> users=new UsersModel().listUsers();
		int flag=0;
		for(Users user: users) {
			if((username.equals(user.getUserName())) && (password.equals(user.getPassword()))) {
				request.setAttribute("firstname", user.getFirstName());
				request.setAttribute("lastname", user.getLastName());
				flag=1;
				request.getRequestDispatcher("home.jsp?username"+username).forward(request, response);
				
			}
			
			
		}
		if(flag==0) {
			request.getRequestDispatcher("index.jsp?message=error").forward(request, response);
		}
		
		
	}


	private void signup(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstname=request.getParameter("firstname");
		String lastname=request.getParameter("lastname");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		String mobileCheck=request.getParameter("mobile");
		long mobile=0;
		if (mobileCheck.matches("\\d{10}")) {
			mobile=Long.parseLong(mobileCheck);
		}
		else {
			request.getRequestDispatcher("signup.jsp?message=error").forward(request, response);
		}
		Users users=new Users(firstname,lastname,username,password,email,mobile);
		new UsersModel().addUser(users);
		new TransactionModel().addUser(username);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}


}
