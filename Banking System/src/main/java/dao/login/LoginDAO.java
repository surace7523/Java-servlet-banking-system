package dao.login;



import java.sql.SQLException;

import bean.login.Login;



public interface LoginDAO {

	public boolean login(Login login);
}
