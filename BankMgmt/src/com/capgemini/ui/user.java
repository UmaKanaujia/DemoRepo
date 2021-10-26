package com.capgemini.ui;
import com.capgemini.service.AxisBank;
import com.capgemini.service.BankInterface;
import com.capgemini.exceptions.insufficientOpeningAmtException;
import com.capgemini.exceptions.invalidAccNumException;
import com.capgemini.exceptions.insufficientBalException;
//new change 26/10/21
//second change
//how are you
import java.util.Scanner;

import com.capgemini.beans.Account;

public class user {
	public static void main(String[]args) {
		System.out.println("Welcome to Axis Bank\nSelect action attempt from the given choices:");
		BankInterface bank = new AxisBank();
		//creating new account
		try {
			System.out.println("Creating new account");
			System.out.println(bank.openAcc("uma", 111,5000, 20000000));
			//System.out.println(bank.openAcc("umaN", 112, 501, 2000000000));
		}catch(insufficientOpeningAmtException ioa) {
			System.out.println("Create Account=Insufficient opening amount");
		}
		//deposit amt
		try {
			System.out.println("deposit amt"+bank.depositAmt(111, 1111111111));
		}catch(invalidAccNumException iae) {
			System.out.println("Deposit amount=Invalid Account number");
		}catch(insufficientBalException e) {
			System.out.println("Deposit amount=insufficient balance");
		}
		//fund transfer
		try { 
			System.out.println("fund transfer"+bank.fundTransfer(111, 1234567, 501, 311111109));
		}catch(invalidAccNumException ian) {
			System.out.println("Fund Transfer = invalid account number");
		}catch(insufficientBalException e) {
			System.out.println("Fund Transfer = insufficient account balance exception");
		}
		//withdraw
		try {
			System.out.println("Withdraw="+bank.withDrawAmt(401, 111, 1000));
		}catch(insufficientBalException e) {
			System.out.println("Withdraw= insufficient balance in yoir acoount");
					
		}catch(invalidAccNumException iane) {
			System.out.println("Withdraw = invalid account number");
		}
		}
	}
