package risrchanish.bank.operation.service;

import java.util.List;

import risrchanish.bank.operation.entity.BankAccount;


public interface AccountOperations {
	
	public BankAccount openBankAccount(BankAccount bankAccount);

	public void deposit(Long accountNumber, Long amount);
	
	public Long withdrawal(Long accountNumber, Long amount);
	
	public List<String> transactionHistory(Long accountNumber);
	
	public boolean isAvailable();
	
	public Long randomAccountNumber();
		
}
