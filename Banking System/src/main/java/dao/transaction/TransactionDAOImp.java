package dao.transaction;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.account.Account;
import bean.transaction.Transaction;
import dao.account.AccountDAO;
import dao.account.AccountDAOImp;
import database.DatabaseConnection;


public class TransactionDAOImp implements TransactionDAO {

	static Connection con
    = DatabaseConnection.getConnection();
	@Override
	public boolean transaction(Transaction trans)  {
		String updateQuery = "update account set balance = ? where accountNo = ?";
		String query
        = "insert into transaction(amount, action, date, "
          + "accountNo) VALUES (?, ?, ?, ?)";
		Account account = trans.getAccount();
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(updateQuery);
			ps.setDouble(1, account.getBalance());
			ps.setInt(2, account.getAccountNo());
			int n = ps.executeUpdate();
			if(n==0)
				return false;
			
			ps = con.prepareStatement(query);
			ps.setDouble(1, trans.getAmount());
			ps.setString(2, trans.getAction());
			ps.setDate(3, trans.getDate());
			ps.setInt(4, account.getAccountNo());
			
			ps.execute();
			
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return false;
		}
		
		
	}

	@Override
	public List<Transaction> report(int accountNo, Date from, Date to)  {
		// TODO Auto-generated method stub
		
		String query = "SELECT * FROM transaction WHERE accountNo = ? AND (date BETWEEN ? AND ?)";
		PreparedStatement ps;
		List<Transaction> transList = new ArrayList<>();
		try {
			ps = con.prepareStatement(query);
			ps.setInt(1, accountNo);
			ps.setDate(2, from);
			ps.setDate(3, to);
			
			ResultSet rs = ps.executeQuery();
		    
		    AccountDAO accountDAO = new AccountDAOImp();
		    Account account;
			
		    
		    while(rs.next())
		    {
		    	Transaction trans = new Transaction();
		    	account = accountDAO.get(rs.getInt("accountNo"));
		    	trans.setAccount(account);
		    	trans.setAmount(rs.getDouble("amount"));
		    	trans.setAction(rs.getString("action"));
		    	trans.setDate(rs.getDate("date"));
		    	transList.add(trans);
		    }
		    	if(transList.isEmpty())
		    		return null;
		    	return transList;
		} catch (SQLException e) {
			
			return null;
		}
		
		
	}

}
