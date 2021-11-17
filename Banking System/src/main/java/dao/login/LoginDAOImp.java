package dao.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.login.Login;
import database.DatabaseConnection;




public class LoginDAOImp implements LoginDAO{

	@Override
	public boolean login(Login login)  {
		// TODO Auto-generated method stub
		Connection con = DatabaseConnection.getConnection();
		PreparedStatement ps;
		try {
			ps = con.prepareStatement
			("SELECT username FROM login WHERE username = ? AND password = ?");
			ps.setString (1, login.getUsername());
			ps.setString (2, login.getPassword());
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
			    return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return false;
		}
			
		return false;
	}

}
