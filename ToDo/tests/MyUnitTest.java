import static org.junit.Assert.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.Test;
import customTools.DBUtil;
import model.*;

public class MyUnitTest {

    @Test
    public void testInsertUser() {
        Tuser user = new Tuser();
        user.setTname("Vicky");
        user.setUsername("vikilee");
        user.setUserpass("pass");
        user.setUserid(100);
        DBUtil.insert(user);
        Tuser returnuser = DBUtil.getUser(100);
        assertTrue(returnuser.getUsername() == user.getUsername());
    }
    
    @Test
    public void testTodo(){
    	SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
    	Todo activity = new Todo();
    	activity.setDescription("Call mom");
    	String datestr = "9/12/2015";
    	Date date = null;
		try {
			date = formatter.parse(datestr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
    	activity.setDuedate(date);
    	activity.setStatus("no");
    	activity.setTitle("Call");
    	activity.setTpriority(10);
    	activity.setTid(100);
    	activity.setTuser(returnUser());
    	DBUtil.insert(activity);
    	Todo returnactiv = DBUtil.getPost(100);
    	assertTrue(returnactiv.getTitle() == activity.getTitle());
    }
    
    public Tuser returnUser(){
        Tuser user = new Tuser();
        user.setTname("Vicky");
        user.setUsername("vikilee");
        user.setUserpass("pass");
        DBUtil.insert(user);
    	return user;
    }

    @Test
    public void TestValidUser(){
    	Tuser user = DBUtil.getUser(10);
    	long test = DBUtil.isValidUser(user);
    	System.out.println("Test: " + test);
    	assertTrue(test >= 1);
    }
    
    
}