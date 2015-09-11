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


@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Delete() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strpostid = request.getParameter("postID");
		long postid = Long.parseLong(strpostid);
		Todo post = DBUtil.getPost(postid);
		DBUtil.delete(post);
		getServletContext().getRequestDispatcher("/SeeList").forward(request, response);
	}

}
