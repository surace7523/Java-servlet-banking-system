package dao.account;



import java.sql.SQLException;

import bean.account.Account;



public interface AccountDAO {

	public boolean addAccount(Account account);
	public Account get(int id);
	
}
