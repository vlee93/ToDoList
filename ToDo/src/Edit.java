import model.*;
import customTools.*;

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


@WebServlet("/Edit")
public class Edit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Edit() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message = "";
		HttpSession session = request.getSession();
		String strpostID = request.getParameter("postID");
		long postID = Long.parseLong(strpostID);
		System.out.println("PostID = " + postID);
		Tuser u = (Tuser) session.getAttribute("user");
		Todo post = DBUtil.getPost(postID);
		String prod = "";
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		Date date = post.getDuedate();
		String strdate = formatter.format(date);
		

		message+="<form style=\"width:50%;\" class=\"form-horizontal\" action=\"UpdatePost\" id=\"myform2\">"+
				"<div class=\"form-group\" >"+
				"<label class=\"control-label col-sm-2\" for=\"name\">Title</label>"+
		    "<div class=\"col-sm-10\">"+
		    "<input type=\"text\" name=\"title\" class=\"form-control\" value ="+post.getTitle()+">"+
		  "</div></div>"+
		  "<div class=\"form-group\">"+
		    "<label class=\"control-label col-sm-2\" for=\"text\">Description</label>"+
		    "<div class=\"col-sm-10\">"+
		    "<input type=\"text\" class=\"form-control\" name=\"description\" value='"+post.getDescription()+"'>"+
		  "</div></div>"+
		  "<div class=\"form-group\">"+
		    "<label class=\"control-label col-sm-2\" for=\"text\" >Due Date</label>"+
		    "<div class=\"col-sm-10\">"+
		    "<input type=\"text\" class=\"form-control\" name=\"duedate\" value="+strdate+">"+
		  "</div></div>"+
		  "<div class=\"form-group\">"+
		    "<label class=\"control-label col-sm-2\" for=\"text\">Status</label>"+
		    "<div class=\"col-sm-10\">"+
		    "<input type=\"text\" class=\"form-control\" name=\"status\" value="+post.getStatus()+">"+
		  "</div></div>"+
		  "<div class=\"form-group\">"+
		    "<label class=\"control-label col-sm-2\" for=\"text\">Priority</label>"+
		    "<div class=\"col-sm-10\">"+
		    "<input type=\"text\" class=\"form-control\" name=\"priority\" value="+post.getTpriority()+">"+
		  "</div></div>"+
		  "<div class=\"form-group\">"+
		    "<label class=\"control-label col-sm-8\" for=\"text\"></label>"+
		  "<div class=\"col-sm-4\">"+
		    "<input type=\"submit\" class=\"form-control\"  value= \"update\"></div></div>"+"</form>";


		request.setAttribute("message", message);
		getServletContext().getRequestDispatcher("/editme.jsp").forward(request, response);
		
	}

}
