package com.capgemini.service;
import com.capgemini.exceptions.insufficientBalException;
import com.capgemini.exceptions.insufficientOpeningAmtException;
import com.capgemini.exceptions.invalidAccNumException;
import com.capgemini.beans.Account;
public interface BankInterface {
	public String openAcc(String accHolder,int accNum, int amt, int bal)throws insufficientOpeningAmtException;
	public int withDrawAmt(int accNum, int amt,int bal)throws invalidAccNumException, insufficientBalException;
	public int depositAmt(int accNum,int amt) throws invalidAccNumException, insufficientBalException;
	public int fundTransfer(int accNum,int accNum2,int amt, int bal)throws insufficientBalException,invalidAccNumException;
	public Account searchAcc(int accNum)throws invalidAccNumException;
	
}
