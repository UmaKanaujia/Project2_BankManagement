package com.services;
import com.beans.*;
import com.exceptions.*;
import java.util.LinkedList;

public class AxisBank implements BankInterface 
{
	
	LinkedList<Account> accounts=new LinkedList<>();
		public String createAccount(int accountNumber,int amount) throws insufficientOpeningAmtException
		{
			Account account = new Account();
			account.setAccountNumber(accountNumber);
			account.setAmount(amount);
			accounts.add(account);
			return "account created successfully";
		}
		private Account searchAccount(int accountNumber) throws invalidAccNumException
		{
			for(Account account : accounts)
			{
				if(account.getAccountNumber()==accountNumber)
				{
					return account;
				}
			}
			throw new invalidAccNumException();
		}
		public int withdrawAmount(int accountNumber,int amount) throws insufficientBalanceException , invalidAccNumException
		{
	Account account=searchAccount(accountNumber);
			
			if((account.getAmount()-amount)>=0)
			{
				account.setAmount(account.getAmount()-amount);
				return account.getAmount();
			}
			
			throw new insufficientBalanceException();
		}
		
		
	public int depositAmount(int accountNumber,int amount)throws invalidAccNumException {
		Account account=searchAccount(accountNumber);
		
			account.setAmount(account.getAmount()+amount);
			return account.getAmount(); 	
	}
	public int[] fundTransfer(int accountNumber1,int accountNumber2,int amount)throws  invalidAccNumException,insufficientBalanceException 
	{
		{
			Account account1=searchAccount(accountNumber1);
			Account account2=searchAccount(accountNumber2);
			if((account1.getAmount()-amount)>=0)
			{
				int[] a= {account1.getAmount()-amount,account2.getAmount()+amount};
				account1.setAmount(account1.getAmount()-amount);
				account2.setAmount(account2.getAmount()+amount);
				return a;
			}
		
		}
		throw new insufficientBalanceException();
	}
	}
