package transactionCheck;

import java.io.Serializable;

public class Person

{

	
	    private String name;
	    private String accountnumber;
	    private String password;
	    private double balance;

	    public Person()
	    {
	        balance = 0;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public String getAccountNumber() {
	        return accountnumber;
	    }

	    public void setAccountNumber(String accountnumber) {
	        this.accountnumber = accountnumber;
	    }

	    public String getPassword() {
	        return password;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }

	    public double getBalance() {
	        return balance;
	    }

	    public void setBalance(double balance) {
	        this.balance = balance;
	    }
	}


