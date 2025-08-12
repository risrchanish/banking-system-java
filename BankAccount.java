package risrchanish.bank.operation.entity;

public class BankAccount {

	private String id;
	private String name;
	private String address;
	private Long balance;
	private Long accountNumber;
	
		
	
	// All args constructor
	public BankAccount(String id, String name, String address, Long balance,Long accountNumber) {
		
		if(id == null || id.isBlank())
		{
			throw new IllegalArgumentException("Id can't be blank");
		}
		
		if(balance == null || balance < 0)
		{
			throw new IllegalArgumentException("balance can't be negative");
		}
		
		if(name == null || name.isBlank())
		{
			throw new IllegalArgumentException("Name can't be blank");
		}
		
		if(address == null || address.isBlank())
		{
			throw new IllegalArgumentException("Address can't be blank");
		}
		
		
		this.id = id;
		this.name = name;
		this.address = address;
		this.balance = balance;
		this.accountNumber = accountNumber;
	}
	
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		if(id == null || id.isBlank())
		{
			throw new IllegalArgumentException("Id can't be blank");
		}
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		
		if(name == null || name.isBlank())
		{
			throw new IllegalArgumentException("Name can't be blank");
		}
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		
		if(address == null || address.isBlank())
		{
			throw new IllegalArgumentException("Address can't be blank");
		}
		this.address = address;
	}

	public Long getBalance() {
		return balance;
	}

	public void setBalance(Long balance) {
		
		if(balance == null || balance < 0)
		{
			throw new IllegalArgumentException("balance can't be negative");
		}
		this.balance = balance;
	}
	
	public void setAccountNumber(Long accountNumber)
	{
		if(accountNumber == null)
		{
			throw new IllegalArgumentException("Account number can't be blank");
		}
		this.accountNumber = accountNumber;
	}
	
	public Long getAccountNumber()
	{
		return accountNumber;
	}



	@Override
	public String toString() {
		return "BankAccount [id=" + id + ", name=" + name + ", address=" + address + ", balance=" + balance
				+ ", accountNumber=" + accountNumber + "]";
	}
	

	
	
		
	
}
