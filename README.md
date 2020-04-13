# Hibernate-and-JSP-Bank

Hello Guys,

Hibernate and JSP Bank is a Dynamic web bank application developed with JSP, Hibernate, POJO and MySQL.

I have used HTML and JSP for front end design and front end logic. POJO for connecting the connecting with the local server and Hibernate
for having the relation with the proect and database by mapping the pojo objects.

In this application, the services that a user can experience are 

  - Create a user profile into the database by entering their information
  - Sending and receiving money from other users who are in the database by entering the other user's information.
  - Depositing a cheque by entering the cheque number.
  - Checking the account balance.
  - View and Updating the account information.

Everytime a user performs one of the above operations, hibernate maps those respective fields with the database objects and displays the
corresponding results.

MVC Architecture is implemented in this project where the operations of the application is written in controller package and database
operations are written in model and the interactive part of the program will be displayed with the help of JSP files.

Some of the other concepts that were included in this application are regular expressions for mobile number validation, amount
while doing a transaction and cheque number while depositing a cheque.
