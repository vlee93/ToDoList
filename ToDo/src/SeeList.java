import javax.persistence.EntityManager;

import customTools.*;
import model.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/SeeList")
public class SeeList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public SeeList() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message = "";
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		HttpSession session = request.getSession();
		Tuser u = (Tuser) session.getAttribute("user");

		try{
			List<Todo> posts = DBUtil.postTodoofUser(u);
			for (Todo topost : posts)
			{
				message += "<div class=\"alert alert-success\"><a href=\"Delete?postID="+ topost.getTid() + "\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\">&times;</a><strong>"
						+ topost.getTitle() +"<br></strong>"
						+ "Description: " + topost.getDescription() + "<br>"
						+ "Priority: " + topost.getTpriority() + "<br>"
						+ "Due Date: <strong>" + topost.getDuedate() +"</strong><br>"
						+ "Status: " + topost.getStatus() + "<br>"
						+ "<a href=\"Edit?postID=" + topost.getTid() + "\" class=\"btn btn-warning\" role=\"button\">Edit</a>"
						+ "</div>";
			}

			
			request.setAttribute("message", message);
			getServletContext().getRequestDispatcher("/List.jsp").forward(request, response);
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

}
