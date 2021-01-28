package com.capgemini.service;
import com.capgemini.beans.Account;
import com.capgemini.exceptions.insufficientBalException;
import com.capgemini.exceptions.insufficientOpeningAmtException;
import com.capgemini.exceptions.invalidAccNumException;
import com.capgemini.service.BankInterface.*;


import java.util.LinkedList;
public class AxisBank implements BankInterface {
	private LinkedList<Account> accounts = new LinkedList<>();
	
		//opening account
	public String openAcc(String accHolder,int accNum, int amt, int bal)throws insufficientOpeningAmtException
	{
		Account account = new Account();
		account.setAccHolder(accHolder);
		account.setAccNum(accNum);
		account.setAmt(amt);
		accounts.add(account);
		System.out.println("acc num is"+accNum);
		if (amt>=500) {
			return "account created succesfully";
		}throw new  insufficientOpeningAmtException() ;
	}
	// search account
	public Account searchAcc(int accNum)throws invalidAccNumException{
		for(Account account:accounts) {
			if (account.getAccNum()==accNum) {
				return account;
			}
		}throw new invalidAccNumException();
	}
	
	// deposit amt
	public int depositAmt(int accNum,int amt) throws invalidAccNumException, insufficientBalException{
		Account account =searchAcc(accNum);
		account.setBal(account.getBal()+amt);
		return account.getBal();
	}
	// withdraw
	public int withDrawAmt(int accNum, int amt,int bal)throws invalidAccNumException, insufficientBalException{
		Account account = searchAcc(accNum);
		System.out.println(accNum+" provided acc num");
		System.out.println(account +"from db");
		if (account.getBal()>500 && account.getBal()-amt>500) {
		account.setBal(account.getBal() - amt); 
		return  account.getBal();
		}
		throw new insufficientBalException();
	}
	//fund transfer
	public int fundTransfer(int accNum,int accNum2,int amt, int bal)throws insufficientBalException,invalidAccNumException{
		System.out.println(accNum+" provided acc num in fund transfer");
		Account account = searchAcc(accNum);
		Account account2 = searchAcc(accNum2);//assigning value of searchAcc() into Account class object account
		if (account.getBal()>500 && account.getBal()-amt >500) {
		int accountt = account.getBal()-amt;
		int accountt2 = account2.getBal()+amt;
		account.setBal(accountt);
		account.setBal(accountt2);
		}throw new insufficientBalException();
		
	}
}