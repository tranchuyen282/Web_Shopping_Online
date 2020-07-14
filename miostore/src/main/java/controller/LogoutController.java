package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Tran Chuyen
 */
public class LogoutController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LogoutController() {
        super();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
       Cookie[] cookies = request.getCookies();
    	if(cookies != null){
            for(Cookie cookie : cookies){
//                if(cookie.getName().equals("JSESSIONID")){
//                    System.out.println("JSESSIONID="+cookie.getValue());
//                }
                cookie.setMaxAge(0);
    		response.addCookie(cookie);
            }
        }
       // String referer = request.getHeader("Referer");
        //System.out.println(referer);
        //invalidate the session if exists
    	HttpSession session = request.getSession(false);
    	//System.out.println("User="+session.getAttribute("customer"));
    	if(session != null){
            session.invalidate();
    	}
        response.sendRedirect("/miostore/home");
    } 

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
       
    }

   
  

}
