package com.services;
import com.exceptions.*;

public interface BankInterface
{
	String createAccount(int accNum,int Amt) throws insufficientOpeningAmtException;
	int withdrawAmount(int accountNumber,int amount) throws insufficientBalanceException , invalidAccNumException;
	int depositAmount(int accountNumber,int amount)throws invalidAccNumException;
	int[] fundTransfer(int accountNumber1,int accountNumber2,int amount)throws invalidAccNumException , insufficientBalanceException;
}