import javax.persistence.EntityManager;
import customTools.*;
import model.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NewAccount
 */
@WebServlet("/NewAccount")
public class NewAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public NewAccount() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String name = request.getParameter("name");
		String username = request.getParameter("username");
		String userpass = request.getParameter("userpass");
		
		try{
			Tuser u = new Tuser();
			u.setTname(name);
			u.setUsername(username);
			u.setUserpass(userpass);
			DBUtil.insert(u);
			getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		}catch (Exception e){
			System.out.println(e);
		} finally {
			em.close();
		}
	}

}
