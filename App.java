package risrchanish.bank.operation;


import java.util.Scanner;


import risrchanish.bank.operation.entity.BankAccount;
import risrchanish.bank.operation.service.AccountOperations;
import risrchanish.bank.operation.service.impl.AccountOperationsImpl;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println("Welcome to Console based Bank Operations\n");

       
        Scanner scanner = new Scanner(System.in);
        
        AccountOperations operations = new AccountOperationsImpl();
        boolean running = true;
        
        while(running)
        {
        	System.out.println("Press 1 to open an account\n");
        	System.out.println("Press 2 to add balance to the account\n");
        	System.out.println("Press 3 to withdraw balance from the account\n");
        	System.out.println("Press 4 to check transactions history for a account\n");
        	System.out.println("Press 5 to exit\n");
        	
        	if(operations.isAvailable())
			{
				System.out.println("You do not have an account. press 1 to add an account \n");
			}
        	
        	int input = scanner.nextInt();
        	scanner.nextLine();
        	
        	switch(input)
        	{
        		case 1 ->
        		{
        			System.out.println("You chose to open an account. Enter the details below \n");
        			System.out.println("Enter id");
        			String id = scanner.next();
        			System.out.println("Enter name of the person");
        			String name = scanner.next();
        			System.out.println("Enter address of the person");
        			String address = scanner.next();
        			System.out.println("Enter minimum balance to open an account");
        			Long balance = scanner.nextLong();
        			Long accountNumber = operations.randomAccountNumber(); 			
        			BankAccount bankAccount = operations.openBankAccount(new BankAccount(id,name,address,balance,accountNumber));
        			System.out.println("You sucessfully created a Bank Account and below is your accountNumber. Keep it safe\n");
        			
        			System.out.println(accountNumber);
        			       			
        		}
        		
        		case 2 ->
        		{
        			System.out.println("You have chosen to add balance into account: \n");
        			
        			System.out.println("Enter an amount to deposit into the account: \n");
        			Long amount = scanner.nextLong();
        			System.out.println("Enter account number \n");
        			Long accountNumber = scanner.nextLong();
        				
        			operations.deposit(accountNumber, amount);
        						        				
        		}
        		
        		case 3 ->
        		{
        			 System.out.println("You have chosen to withdraw balance from an account: \n");
        			 

        			System.out.println("Enter an amount to withdraw from the account: \n");
        			Long amount = scanner.nextLong();
        			System.out.println("Enter account number \n");
        			Long accountNumber = scanner.nextLong();
        			
        			operations.withdrawal(accountNumber, amount);
        			
        			 
        		}
        		
        		case 4 ->
        		{
        			System.out.println("You have chosen to see the transaction history \n");
        			
        			System.out.println("Enter account number: \n");
        			Long accountNumber = scanner.nextLong();
        			
        			System.out.println(operations.transactionHistory(accountNumber));
        					
        		}
        		
        		case 5 ->
        		{
        			System.out.println("You have chosen to exit. Good Bye!");
        			running = false;
        		}
        		
        		default ->
        		{
        			System.out.println("Wrong input! Choose from 1 to 5");
        		}
        	}
        }
        
        scanner.close();
    }
}
