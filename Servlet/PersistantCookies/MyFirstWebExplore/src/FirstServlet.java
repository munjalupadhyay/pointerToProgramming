

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
 * Servlet implementation class FirstServlet
 */
@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    /*public FirstServlet() {
        super();
        // TODO Auto-generated constructor stub
    }*/

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
				out.println("I  have cookie");
				ServletContext context = getServletContext();
				HashMap<String,HttpSession> map= (HashMap<String,HttpSession>)context.getAttribute("storedUsers");
				
				
				HttpSession retrivedSession = map.get(findCookie(request.getCookies(),"cookiedJsessionId"));
				// possibly we do not able to find session in map also !!
				if(retrivedSession == null){
					out.println(" But  id not found in map :(");
					
					// create session,
					// set cookies
					retrivedSession = request.getSession();
					Cookie cookie=new Cookie("cookiedJsessionId",retrivedSession.getId());
					cookie.setMaxAge(30*60);
					response.addCookie(cookie);
				}
				session=retrivedSession;
			}
			else{ // if not found in map then create new session and add jsessionid in cookie
				// create session,
				// set cookies
				out.println("I don't have cookie");
				session = request.getSession();
				Cookie cookie=new Cookie("cookiedJsessionId",session.getId());
				cookie.setMaxAge(30*60);
				response.addCookie(cookie);
			}
			
			
			
		}
		
		session.setAttribute("name", request.getParameter("firstname"));
		session.setAttribute("surname", request.getParameter("lastname"));
		
		out.print(request.getParameter("firstname"));
		out.print("<br>");
		out.print(request.getParameter("lastname"));
		out.print("<br>");
		out.print("<a href='/MyFirstWebExplore/SecondServlet'>see my names</a>");
		out.print("<br>");
		
		out.println("cookie id : "+session.getId());
		
		
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
