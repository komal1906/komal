package com.capgemini.repository;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import com.capgemini.beans.Customer;
import com.capgemini.beans.Transaction;
import com.capgemini.exception.MobileNumberNotExistException;

public class WalletRepoImpl implements WalletRepo {

	LinkedList<Customer> l = new LinkedList<>();
	LinkedList<Transaction> tl= new LinkedList<>();

	@Override
	public boolean save(Customer customer) {
		// TODO Auto-generated method stub
		return l.add(customer);
	}

	@Override
	public Customer findOne(String mobilenumber) throws MobileNumberNotExistException {
		// TODO Auto-generated method stub
		ListIterator<Customer> it = l.listIterator();
		while (it.hasNext()) {
			Customer c = it.next();
			if (c.getMobileNumber().equals(mobilenumber)) {
				return c;
			}

		}
		return null;
	}

	@Override
	public boolean saveTransaction(Transaction transaction) {
		// TODO Auto-generated method stub
		
		
				return tl.add(transaction); 
	}

	@Override
	public List<Transaction> findAll(String mobileNumber) {
		// TODO Auto-generated method stub
		int flag=0;
		LinkedList <Transaction> l1= new LinkedList<>();
		for(Transaction entry:tl)
		{
			if(entry.getMobileNumber()==mobileNumber)
			{
				l1.add(entry);
				flag=1;
			}
		}
		if(flag==1)
			return(l1);
		
		return null;
	}
	
	

}
