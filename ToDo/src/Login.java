import javax.persistence.EntityManager;
import javax.persistence.metamodel.SetAttribute;

import customTools.*;
import model.*;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String username = request.getParameter("username");
		String userpass = request.getParameter("password");
		Tuser u = new Tuser();
		u.setUsername(username);
		u.setUserpass(userpass);
		long userid = DBUtil.isValidUser(u);
		Tuser user = DBUtil.getUser(userid);
		HttpSession session = request.getSession();
		
		try{
			if ((userid) > 0)
			{
				session.setAttribute("user", user);
				getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
			}
			else
			{
				String error = "<div class=\"alert alert-danger\"><strong>Error!</strong> You entered the wrong username or password.</div>";
				request.setAttribute("error", error);
				getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
			}
		}catch (Exception e)
		{
			System.out.println(e);
		} finally{
			em.close();
		}
	}

	}


