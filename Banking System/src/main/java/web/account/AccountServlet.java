package web.account;
import javax.servlet.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Date;

import bean.account.Account;
import dao.account.AccountDAO;
import dao.account.AccountDAOImp;




/**
 * Servlet implementation class AccountServlet
 */
@WebServlet("/account")
public class AccountServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
	private AccountDAO accountDAO;   
/**
 * @see HttpServlet#HttpServlet()
 */
	public AccountServlet() {
    
		accountDAO = new AccountDAOImp();
	}



/**
 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
		int accountNo =Integer.parseInt(request.getParameter("accountNo")) ;
		
	String name = request.getParameter("name");
	Date dob =Date.valueOf( request.getParameter("dob"));
	String address = request.getParameter("address");
	String email = request.getParameter("email");
	String type = request.getParameter("type");
	Account account = new Account(accountNo, name, dob, address, email, type, 100 );
	
	if(accountDAO.addAccount(account))
	{
		HttpSession session = request.getSession();
		session.setAttribute("errorMessage", "");
		response.sendRedirect("success.jsp");
	}
	else
	{
		HttpSession session = request.getSession();
		session.setAttribute("errorMessage", "Account Could not be created");
		response.sendRedirect("account.jsp");
	}
	
}}
