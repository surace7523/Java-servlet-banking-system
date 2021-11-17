package dao.transaction;



import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import bean.transaction.Transaction;



public interface TransactionDAO {

	public boolean transaction(Transaction trans);
	
	public List<Transaction> report(int accountNo, Date from, Date to);
}
