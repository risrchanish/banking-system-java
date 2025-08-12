package risrchanish.bank.operation.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import risrchanish.bank.operation.entity.BankAccount;
import risrchanish.bank.operation.service.AccountOperations;

public class AccountOperationsImpl implements AccountOperations{

	
	
	private Set<BankAccount> accounts = new HashSet<>();	
	private Map<Long,List<String>> transactions = new HashMap<>();
	
	private BankAccount matchAccount(Long account)
	{
		BankAccount matchedAccount = accounts.stream()
									.filter(accNum -> account.equals(accNum.getAccountNumber()))
									.findFirst().orElseThrow(() -> new NoSuchElementException("Account not found"));
		return matchedAccount;
		
	}
		
	// Adding balance to an account
	
	@Override
	public void deposit(Long accountNumber, Long amount) 
	{
		BankAccount bankAccount= matchAccount(accountNumber);
		
		if(amount == null || amount < 0)
		{
			throw new IllegalArgumentException("Deposit amount must be positive \n");
		}
		
		bankAccount.setBalance(bankAccount.getBalance()+amount);
			
		// Account specific transactions
			
		transactions.computeIfAbsent(accountNumber, 
										list -> new ArrayList<>()).add("Deposit: "+amount +" Available: "+bankAccount.getBalance());
			
		System.out.println("Account " +accountNumber + " Deposited with INR "+amount + " \n");
		
		System.out.println("Total Amount: "+bankAccount.getBalance()+" \n");
		
	}
	
	// Withdrawing balance from an account

	@Override
	public Long withdrawal(Long accountNumber, Long amount) 
	{
		BankAccount bankAccount= matchAccount(accountNumber);
		if(bankAccount.getBalance() >= amount)
		{
			bankAccount.setBalance(bankAccount.getBalance() - amount);
				
			// Maintaining individual account level transactions
				
			transactions.computeIfAbsent(accountNumber, 
												list -> new ArrayList<>()).add("Withdraw: "+amount +" Available: "+bankAccount.getBalance());
				
			System.out.println("Available balance: "+bankAccount.getBalance());
			return bankAccount.getBalance();
		}
		else
		{
				
			throw new IllegalArgumentException("Withdrawal amount must be positive");
				
		}
		
	}

	// transaction Withdrawal history
	
	public List<String> transactionHistory(Long accountNumber)
	{
	
		List<String> history = transactions.get(accountNumber);
		
		if(history != null)
		{
			return history;
		}
		
		return Collections.emptyList();
		
	}
	
	// opening a bank account

	@Override
	public BankAccount openBankAccount(BankAccount bankAccount) {
		
		accounts.add(bankAccount);	
		return bankAccount;
	}
	
	// checking for an account
	
	public boolean isAvailable()
	{
		return accounts.isEmpty();
	}

	
	// generating random account number
	
	public Long randomAccountNumber()
	{
		long min = 100000000L;
		long max = 999999999L;
		return min + (long)(Math.random()*(max-min+1));	
		
	}


}
