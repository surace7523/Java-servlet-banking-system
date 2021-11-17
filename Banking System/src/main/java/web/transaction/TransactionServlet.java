package web.transaction;

import java.io.IOException;

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
@WebServlet("/transaction")
public class TransactionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private TransactionDAO transactionDAO; 
    private AccountDAO accountDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TransactionServlet() {
        
        transactionDAO = new TransactionDAOImp();
        accountDAO = new AccountDAOImp();
    }

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Account account = accountDAO.get(Integer.parseInt(request.getParameter("accountNo")));
		if(account != null)
		{
			long millis=System.currentTimeMillis();  
	        java.sql.Date date=new java.sql.Date(millis); 
	        double amount = Double.parseDouble(request.getParameter("amount"));
	        String action = request.getParameter("action");
			Transaction trans = new Transaction(amount,action,date,account);
			if(!trans.transaction())
			{
				HttpSession session = request.getSession();
				session.setAttribute("errorMessage", "Insufficient Balance");
				response.sendRedirect("transaction.jsp");
			}
			else
			{
				if(transactionDAO.transaction(trans))
					{
					HttpSession session = request.getSession();
					session.setAttribute("errorMessage", "Successful");
					response.sendRedirect("transaction.jsp");
					}
				else
				{
					HttpSession session = request.getSession();
					session.setAttribute("errorMessage", "Unsuccessful");
					response.sendRedirect("transaction.jsp");
				}
					
			}
			
		}
		else
		{
			HttpSession session = request.getSession();
			session.setAttribute("errorMessage", "Account Not Found");
			response.sendRedirect("transaction.jsp");
		}
			
		
	
		
		
	}

}
