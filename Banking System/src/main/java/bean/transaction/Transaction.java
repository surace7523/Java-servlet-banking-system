package bean.transaction;



import java.sql.Date;

import bean.account.Account;

public class Transaction {

	private double amount;
	private String action;
	private Date date;
	private Account account;
	
	public Transaction(double amount, String action, Date date, Account account) {
		this.amount = amount;
		this.action = action;
		this.date = date;
		this.account = account;
	}
	
	public Transaction() {
		// TODO Auto-generated constructor stub
	}

	public boolean transaction()
	{
		if(action.equals("withdraw"))
			return withdraw();
		else
			return deposit();
	}
	
	private boolean withdraw()
	{
		if(account.getBalance()>=amount)
		{
			account.setBalance(account.getBalance()-amount);
			return true;
		}
		return false;
	}
	
	private boolean deposit()
	{
		if(amount>0)
		{
			account.setBalance(account.getBalance()+amount);
			return true;
		}
		return false;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "Transaction [amount=" + amount + ", action=" + action + ", date=" + date + ", account=" + account + "]";
	}
	
	
	
}
