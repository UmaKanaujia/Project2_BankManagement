package com.ui;
import com.exceptions.*;
import com.services.*;

public class Client 
{
	public static void main(String[] args)
	{
		 BankInterface bank=new AxisBank();
		try 
		{
			System.out.println("Creating a new Account");
			System.out.println(bank.createAccount(101,5000));
			System.out.println(bank.createAccount(102,10000));
		}
		catch(insufficientOpeningAmtException ioa) {
			System.out.println("Insufficient amount for opening  account. Minimum balance must be 500");
		}
		try
		{
			System.out.println("Withdraw Amount");
			System.out.println("Balance of account no 101 is: "+bank.withdrawAmount(101, 5000));
		}
		catch(insufficientBalanceException inb)
		{
			System.out.println("Insufficient Account Balance");
		}
		catch(invalidAccNumException ina)
		{
			System.out.println("Invalid Account Number");
		}
		try 
		{
			System.out.println("Deposit Amount");
			System.out.println("Amount in account no 102 is : "+bank.depositAmount(102,7000));
		}
		catch(invalidAccNumException ina)
		{
			System.out.println("Invalid Account Number");
		}
		try 
		{
			System.out.println("Fund Transfer");
			int []a=bank.fundTransfer(101, 102, 2000);
			System.out.println("New balance of account number 101: "+a[0]+"  New balance of account number 102 : "+a[1]);
		}
		catch(insufficientBalanceException inb) 
		{
			System.out.println("Insufficient Balance");
		}
		catch(invalidAccNumException ina)
		{
			System.out.println("Invalid Account Number");
		}
	}

}