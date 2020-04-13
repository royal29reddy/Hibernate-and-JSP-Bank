package org.kautilya.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


	@Entity(name="balances")
	@Table(name="balances")
	public class Transaction {

		@Id
		@Column(name="account_number")
		long accountNumber;
		@Column(name="user_name")
		String userName;
		@Column(name="balance")
		long balance;
		
		public Transaction() {
			
		}
		public Transaction(String userName) {
			this.userName = userName;
		}
		public Transaction(int accountNumber, String userName) {
			this.accountNumber = accountNumber;
			this.userName = userName;
		}
		public long getAccountNumber() {
			return accountNumber;
		}
		public void setAccountNumber(int accountNumber) {
			this.accountNumber = accountNumber;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public long getBalance() {
			return balance;
		}
		public void setBalance(long balance) {
			this.balance = balance;
		}
		

		


		
		
}
