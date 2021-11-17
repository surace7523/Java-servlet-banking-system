package web.login;

import java.io.IOException;

import bean.login.Login;
import dao.login.LoginDAO;
import dao.login.LoginDAOImp;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private LoginDAO loginDAO;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        
        loginDAO = new LoginDAOImp();
    }

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Login login = new Login(username,password);
		
		if(loginDAO.login(login))
		{
			HttpSession session = request.getSession();
			session.setAttribute("errorMessage", "");
			response.sendRedirect("LandingPage.jsp");
		}
		else
		{
			HttpSession session = request.getSession();
			session.setAttribute("errorMessage", "Inavlid Username or Password");
			response.sendRedirect("login.jsp");
		}
		
	}

}
