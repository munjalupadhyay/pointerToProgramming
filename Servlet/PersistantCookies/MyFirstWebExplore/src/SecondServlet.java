

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SecondServlet
 */
@WebServlet("/SecondServlet")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SecondServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//Dog dog = (Dog)getServletContext().getAttribute("dog");
		
		//out.append(dog.getBreed());
		
		HttpSession session = request.getSession(false);
		
		if(session == null){
			// no session found.
			// so we have to search in map.
			
			
			if(findCookie(request.getCookies(),"cookiedJsessionId") != null){ // try to find jsessionid cookie. 
				ServletContext context = getServletContext();
				HashMap<String,HttpSession> map= (HashMap<String,HttpSession>)context.getAttribute("storedUsers");
				
				
				HttpSession retrivedSession = map.get(findCookie(request.getCookies(),"cookiedJsessionId"));
				// possibly we do not able to find session in map also !!
				if(retrivedSession == null){
					// create session,
					// set cookies
					retrivedSession = request.getSession();
					Cookie cookie=new Cookie("cookiedJsessionId",retrivedSession.getId());
					cookie.setMaxAge(30*60);
					response.addCookie(cookie);
				}
				session=retrivedSession;
			}
			else{
				// create session,
				// set cookies
				session = request.getSession();
				Cookie cookie=new Cookie("cookiedJsessionId",session.getId());
				cookie.setMaxAge(30*60);
				response.addCookie(cookie);
			}
			// if not found in map then create new session and add jsessionid in cookie
			
			
		}
		
		out.println(findCookie(request.getCookies(),"cookiedJsessionId"));
		out.println(session.getAttribute("name"));
		out.println(session.getAttribute("surname"));
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	String findCookie(Cookie[] cookies , String name){
		
		if(cookies == null){
			return null;
		}
		
		for(Cookie cookie : cookies){
			if(cookie.getName().equals(name)){
				return cookie.getValue();
			}
		}
		return null;
		
	}


}
