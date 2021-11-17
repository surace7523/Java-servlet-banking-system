package bean.account;



import java.sql.Date;

public class Account {

	private int accountNo;
	private String name;
	private Date dob;
	private String address;
	private String email;
	private String type;
	
	private double balance;
	
	public Account(int accountNo, String name, Date dob, String address, String email, String type, double balance) {
		this.accountNo = accountNo;
		this.name = name;
		this.dob = dob;
		this.address = address;
		this.type = type;
		this.balance = balance;
		this.email = email;
	}
	
	
	public Account() {
		// TODO Auto-generated constructor stub
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public int getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}


	@Override
	public String toString() {
		return "Account [accountNo=" + accountNo + ", name=" + name + ", dob=" + dob + ", address=" + address
				+ ", email=" + email + ", type=" + type + ", balance=" + balance + "]";
	}
	
	
}
