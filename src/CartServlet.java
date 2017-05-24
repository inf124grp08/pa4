import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/cart")
@SuppressWarnings("serial")
public class CartServlet extends HttpServlet {
 
  public void service(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    String id = request.getParameter("id");
    String qty = request.getParameter("qty");
    
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    Cookie cookie = new Cookie(id, qty);                                
    response.addCookie(cookie);                                                        
    response.sendRedirect("WEB_INF/home.jsp"); 
  }
}
