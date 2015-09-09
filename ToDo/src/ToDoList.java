import javax.persistence.EntityManager;

import customTools.*;
import model.*;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/ToDoList")
public class ToDoList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ToDoList() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		try{
				String title= request.getParameter("title");
				String strdate= request.getParameter("duedate");
				Date duedate = formatter.parse(strdate);
				String strpriority= request.getParameter("priority");
				int priority = Integer.parseInt(strpriority);
				String description= request.getParameter("description");
				HttpSession session = request.getSession();
				Tuser user = (Tuser) session.getAttribute("user");
		
				Todo activ = new Todo();
				activ.setDescription(description);
				activ.setDuedate(duedate);
				activ.setStatus("no");
				activ.setTpriority(priority);
				activ.setTuser(user);
				activ.setTitle(title);
				DBUtil.insert(activ);

		} catch (Exception e){
			e.printStackTrace();;
		} finally {
			em.close();
		}
		getServletContext().getRequestDispatcher("/SeeList").forward(request, response);
	}

}
