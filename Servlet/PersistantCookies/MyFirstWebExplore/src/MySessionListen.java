

import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class MySessionListen
 *
 */
@WebListener
public class MySessionListen implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public MySessionListen() {
        // TODO Auto-generated constructor stub
    }
       
    /**
     * @see HttpSessionEvent#HttpSessionEvent(HttpSession)
     */
   

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent arg0)  { 
         // TODO Auto-generated method stub
    	// take jsessionid of newly created session.
    	// retrive hashmap from context. for that you have to have cookie named jsessionid
    	// store jsessionid as a key and HttpSession object as a value.
    	HttpSession session = arg0.getSession();
    	ServletContext context = session.getServletContext();
    	String jSessionId=session.getId();
    	HashMap<String,HttpSession> map= (HashMap<String,HttpSession>)context.getAttribute("storedUsers");
    	map.put(jSessionId, session);
    	
    	
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent arg0)  { 
         // TODO Auto-generated method stub
    }
	
}
