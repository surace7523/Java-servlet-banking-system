package web.transaction;
import javax.servlet.*;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

import bean.account.Account;
import bean.login.Login;
import bean.transaction.Transaction;
import dao.account.AccountDAO;
import dao.account.AccountDAOImp;
import dao.login.LoginDAO;
import dao.login.LoginDAOImp;
import dao.transaction.TransactionDAO;
import dao.transaction.TransactionDAOImp;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/statement")
public class StatementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private TransactionDAO transactionDAO; 
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StatementServlet() {
        
        transactionDAO = new TransactionDAOImp();
        
    }

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int accountNo = Integer.parseInt(request.getParameter("account"));
		Date from = Date.valueOf(request.getParameter("from"));
		Date to = Date.valueOf(request.getParameter("to"));
		
		List<Transaction> list = transactionDAO.report(accountNo, from, to);
		if(list==null)
		{
			HttpSession session = request.getSession();
			session.setAttribute("errorMessage", "Record not Found");
			response.sendRedirect("statement.jsp");
		}
		else
		{
			HttpSession session = request.getSession();
			int size = 3;
			if(size>list.size())
				size = list.size();
			for(int i = 0; i<size; i++)
			{
				Transaction trans = list.get(i);
				session.setAttribute("amount"+i, trans.getAmount());
				session.setAttribute("action"+i, trans.getAction());
				session.setAttribute("date"+i, trans.getDate());
			}
			response.sendRedirect("Report.jsp");
		}
		
		
		
	}

}
