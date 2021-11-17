package dao.account;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.account.Account;
import database.DatabaseConnection;


public class AccountDAOImp implements AccountDAO{

	static Connection con
    = DatabaseConnection.getConnection();
	@Override
	public boolean addAccount(Account account)  {
		
		String query
        = "insert into account(accountNo, name, dob, address, "
          + "email, type, balance) VALUES (?, ?, ?, ?, ?, ?, ?)";
		
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(query);
			ps.setInt(1, account.getAccountNo());
			ps.setString(2, account.getName());
			ps.setDate(3, account.getDob());
			ps.setString(4, account.getAddress());
			ps.setString(5, account.getEmail());
			ps.setString(6, account.getType());
			ps.setDouble(7, account.getBalance());
			
			 ps.execute();
			 return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return false;
		}
		
		
		
		
	}

	@Override
	public Account get(int id) {
		// TODO Auto-generated method stub
		String query
        = "select * from account where accountNo= ?";
    PreparedStatement ps;
	try {
		ps = con.prepareStatement(query);
		 ps.setInt(1, id);
		    
		    ResultSet rs = ps.executeQuery();
		    boolean check = false;
		    Account account = new Account();
		    
		    while (rs.next()) {
		        check = true;
		        account.setAccountNo(rs.getInt("accountNo"));
		        account.setName(rs.getString("name"));
		        account.setAddress(rs.getString("address"));
		        account.setDob(rs.getDate("dob"));
		        account.setType(rs.getString("type"));
		        account.setBalance(rs.getDouble("balance"));
		        account.setEmail(rs.getString("email"));
		    }

		    if (check == true) {
		        return account;
		    }
		    else
		        return null;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		return null;
	}

   
	}
	
	

}
