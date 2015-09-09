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

import customTools.DBUtil;


@WebServlet("/UpdatePost")
public class UpdatePost extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public UpdatePost() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Todo list = new Todo();
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		String strdate = request.getParameter("duedate");
		Date duedate = null;
		try {
			duedate = formatter.parse(strdate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		list.setTitle(request.getParameter("title"));
		list.setDescription(request.getParameter("description"));
		list.setDuedate(duedate);
		list.setStatus(request.getParameter("status"));
		list.setTpriority(Integer.parseInt(request.getParameter("priority")));
		DBUtil.update(list);
		
		getServletContext().getRequestDispatcher("/SeeList").forward(request, response);
		
	
	}

}
