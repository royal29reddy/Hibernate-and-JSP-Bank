package org.kautilya.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kautilya.entity.Users;
import org.kautiya.model.TransactionModel;
import org.kautiya.model.UsersModel;

@WebServlet("/operations")
public class OperationsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		action(request,response);
	}

	
	private void action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String useraction=request.getParameter("action");
		String amount="";
		String username="";
		String userfirstname="";
		String userlastname="";
		String userusername="";
		String useremail="";
		long usermobile=0;
		long useraccount=0;
		long useramount=0;

		switch(useraction) {
		case "send":

			username=request.getParameter("username");
			userfirstname=request.getParameter("userfirstname");
			userlastname=request.getParameter("userlastname");
			userusername=request.getParameter("userusername");
			useremail=request.getParameter("useremail");
			usermobile=Long.parseLong(request.getParameter("usermobile"));
			amount=request.getParameter("amount");
			if (Long.parseLong(amount)>0) {
				useramount=Long.parseLong(amount);
			}
			else {
				request.getRequestDispatcher("pay.jsp?operation="+useraction+"&message=amount&username="+username).forward(request, response);
			}
			List<Users> userSend=new UsersModel().listUsers();
			for(Users user:userSend) {
				if(username.equals(user.getUserName())) {
					useraccount=user.getaccount_number();
				}
			}

			for(Users user:userSend) {
				
				if((userusername.equals(user.getUserName())) && (userfirstname.equals(user.getFirstName()))
				&& (userlastname.equals(user.getLastName())) && (useremail.equals(user.getEmail()))
				&& (usermobile==user.getMobile()))
				
				{
					int useruseraccount= (int)user.getaccount_number();
					if((new TransactionModel().sendMoney(useramount,useraccount,useruseraccount,username,userusername).isEmpty())){	
					}
					else {
						response.sendRedirect("home.jsp?username="+username);
					}
				}
				
			}

			break;
			
		case "request":

			username=request.getParameter("username");
			userfirstname=request.getParameter("userfirstname");
			userlastname=request.getParameter("userlastname");
			userusername=request.getParameter("userusername");
			useremail=request.getParameter("useremail");
			usermobile=Long.parseLong(request.getParameter("usermobile"));
			amount=request.getParameter("amount");
			if (Long.parseLong(amount)>0) {
				useramount=Long.parseLong(amount);
			}
			else {
				request.getRequestDispatcher("pay.jsp?operation="+useraction+"&message=amount&username="+username).forward(request, response);
			}
			List<Users> userRequest=new UsersModel().listUsers();
			for(Users user:userRequest) {
				if(username.equals(user.getUserName())) {
					useraccount=user.getaccount_number();
				}
			}
			for(Users user:userRequest) {
				
				if((userusername.equals(user.getUserName())) && (userfirstname.equals(user.getFirstName()))
				&& (userlastname.equals(user.getLastName())) && (useremail.equals(user.getEmail()))
				&& (usermobile==user.getMobile()))
				
					{
					int useruseraccount=(int) user.getaccount_number();
					if((new TransactionModel().requestMoney(useramount,useraccount,useruseraccount,username,userusername).isEmpty())){
						
					}
					else {
						
						response.sendRedirect("home.jsp?username="+username);;
					}
					}
			}
			break;
			
		case "deposit":
			
			username=request.getParameter("username");
			
			amount=request.getParameter("amount");
			if (Long.parseLong(amount)>0) {
				useramount=Long.parseLong(amount);
			}
			else {
				request.getRequestDispatcher("pay.jsp?operation="+useraction+"&message=amount&username="+username).forward(request, response);
			}
			List<Users> userDeposit=new UsersModel().listUsers();
			for(Users user:userDeposit) {
				if(username.equals(user.getUserName())) {
					useraccount=user.getaccount_number();
					new TransactionModel().depositCheque(useramount,username,useraccount);
				}
			}

			break;
			
		case "update":
			
	
			userfirstname=request.getParameter("fname");
			userlastname=request.getParameter("lname");
			username=request.getParameter("uname");
			String userpassword=request.getParameter("password");
			useremail=request.getParameter("email");
			String usermobileCheck=request.getParameter("mobile");
			if (usermobileCheck.matches("\\d{10}")) {
				usermobile=Long.parseLong(usermobileCheck);
			}
			else {
				request.getRequestDispatcher("home.jsp?message=mobile&username="+username).forward(request, response);
			}
			long accountNumber=Long.parseLong(request.getParameter("accountNumber"));
			Users users=new Users(accountNumber,userfirstname,userlastname,username,userpassword,useremail,usermobile);
			new UsersModel().updateUser(users);
			new TransactionModel().updateUser(accountNumber,username);
			
					}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operation=request.getParameter("operation");
		switch(operation) {
		case "send":
			sendPayment(request,response);
			break;
		case "request":
			requestPayment(request,response);
			break;
			
		case "deposit":
			depositCheque(request,response);
		}
	}





	private void requestPayment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("operation");
		String username=request.getParameter("username");
		String userfirstname=request.getParameter("userfirstname");
		String userlastname=request.getParameter("userlastname");
		String userusername=request.getParameter("userusername");
		String useremail=request.getParameter("useremail");
		String usermobileCheck=request.getParameter("usermobile");
		long usermobile=0;
		if (usermobileCheck.matches("\\d{10}")) {
			usermobile=Long.parseLong(usermobileCheck);
		}
		else {
			request.getRequestDispatcher("pay.jsp?operation="+action+"&message=error&username="+username).forward(request, response);
		}
		request.setAttribute("action", action);
		request.setAttribute("username", username);
		request.setAttribute("userfirstname", userfirstname);
		request.setAttribute("userlastname", userlastname);
		request.setAttribute("userusername", userusername);
		request.setAttribute("useremail", useremail);
		request.setAttribute("usermobile", usermobile);
		int flag=0;
		List<Users> users=new UsersModel().listUsers();
		for(Users user:users) {
			if((userusername.equals(user.getUserName())) && (userfirstname.equals(user.getFirstName()))
			&& (userlastname.equals(user.getLastName())) && (useremail.equals(user.getEmail()))
			&& (usermobile==user.getMobile())) {
				flag=1;
				request.getRequestDispatcher("amount.jsp").forward(request, response);
			}
		}
		if(flag==0) {
			request.getRequestDispatcher("pay.jsp?message=error&operation="+action).forward(request, response);
		}
		
	}


	private void sendPayment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("operation");
		String username=request.getParameter("username");
		String userfirstname=request.getParameter("userfirstname");
		String userlastname=request.getParameter("userlastname");
		String userusername=request.getParameter("userusername");
		String useremail=request.getParameter("useremail");
		String usermobileCheck=request.getParameter("usermobile");
		long usermobile=0;
		if (usermobileCheck.matches("\\d{10}")) {
			usermobile=Long.parseLong(usermobileCheck);
		}
		else {
			request.getRequestDispatcher("pay.jsp?operation="+action+"&message=error&username="+username).forward(request, response);
		}
		request.setAttribute("action", action);
		request.setAttribute("username", username);
		request.setAttribute("userfirstname", userfirstname);
		request.setAttribute("userlastname", userlastname);
		request.setAttribute("userusername", userusername);
		request.setAttribute("useremail", useremail);
		request.setAttribute("usermobile", usermobile);
		int flag=0;
		List<Users> users=new UsersModel().listUsers();
		for(Users user:users) {
			if((userusername.equals(user.getUserName())) && (userfirstname.equals(user.getFirstName()))
			&& (userlastname.equals(user.getLastName())) && (useremail.equals(user.getEmail()))
			&& (usermobile==user.getMobile())) {
				flag=1;
				request.getRequestDispatcher("amount.jsp").forward(request, response);
			}
		}
		if(flag==0) {
			request.getRequestDispatcher("pay.jsp?message=error&operation="+action).forward(request, response);
		}
		
	}
	
	private void depositCheque(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("operation");
		String username=request.getParameter("username");
		String checknumberCheck=request.getParameter("chequeNumber");
		System.out.println("hey this is cheque number" +checknumberCheck);
		if((checknumberCheck.matches("\\d{10}"))&&(Long.parseLong(checknumberCheck)>0)) {
			
		}
		else {
			request.getRequestDispatcher("home.jsp?message=cheque&username="+username).forward(request, response);
		}
		request.setAttribute("action", action);
		request.setAttribute("username", username);
		request.getRequestDispatcher("amount.jsp").forward(request, response);
		
	}

}
