package com.capgemini.view;

import java.math.BigDecimal;
import java.util.List;
import java.util.ListIterator;

import com.capgemini.beans.Transaction;
import com.capgemini.exception.DuplicateIdentityException;
import com.capgemini.exception.InsufficientAmountException;
import com.capgemini.exception.MobileNumberNotExistException;
import com.capgemini.service.WalletService;
import com.capgemini.service.WalletServiceImpl;

public class WalletMainApp {

	public static void main(String[] args) throws MobileNumberNotExistException, DuplicateIdentityException, InsufficientAmountException {
		// TODO Auto-generated method stub
		
		WalletService walletService = new WalletServiceImpl();
		
		
		walletService.createAccount("Ravi", "1",new BigDecimal("10000.0"));
		walletService.createAccount("piliwali", "2",new BigDecimal("50000"));
		
		System.out.println(walletService.showBalance("1").getWallet().getBalance());
		System.out.println(walletService.showBalance("2").getWallet().getBalance());
		
		walletService.depositAmount("1",new BigDecimal("30000"));
		walletService.depositAmount("2",new BigDecimal("40000"));
		
		System.out.println(walletService.showBalance("1").getWallet().getBalance());
		System.out.println(walletService.showBalance("2").getWallet().getBalance());
		
		walletService.withdrawAmount("1",new BigDecimal("20000"));
		walletService.withdrawAmount("2",new BigDecimal("20000"));

		System.out.println(walletService.showBalance("1").getWallet().getBalance());
		System.out.println(walletService.showBalance("2").getWallet().getBalance());
		
		walletService.fundTransfer("1", "2",new BigDecimal("2000"));
		
		System.out.println(walletService.showBalance("1").getWallet().getBalance());
		System.out.println(walletService.showBalance("2").getWallet().getBalance());
		
		
		//Printing Transactions List
		List<Transaction> l = walletService.showTransaction("2");
		ListIterator<Transaction> it = l.listIterator();
		
		while(it.hasNext())
		{
			Transaction transaction=it.next();
			if(transaction.getWithdrawMobileNumber()==null)
			{
				System.out.println("Id: "+transaction.getId()+"  Transaction Type:"+"Deposit"+"  Deposit Mobile Number:"+transaction.getDepositMobileNumber()+"  Deposited Amount:"+transaction.getAmount());
			}
			else if(transaction.getDepositMobileNumber()==null)
			{
				System.out.println("Id: "+transaction.getId()+"  Transaction Type:"+"Withdraw"+"  Withdraw Mobile Number:"+transaction.getWithdrawMobileNumber()+"  Withdrawn Amount:"+transaction.getAmount());
			}
			else
			{
				if(transaction.getDepositMobileNumber()==transaction.getMobileNumber())
				{
					System.out.println("Id: "+transaction.getId()+"  Transaction Type:"+"Fund Tranfered"+"  Sender Mobile Number:"+transaction.getDepositMobileNumber()+"  Receiver Mobile Number:"+transaction.getWithdrawMobileNumber()+" Transferred Amount:"+transaction.getAmount());
				}
				else
				{
					System.out.println("Id: "+transaction.getId()+"  Transaction Type:"+"Fund Received"+"  Sender Mobile Number:"+transaction.getDepositMobileNumber()+"  Receiver Mobile Number:"+transaction.getWithdrawMobileNumber()+" Received Amount:"+transaction.getAmount());
				}
				
			}
		}
		
		
	}

}
