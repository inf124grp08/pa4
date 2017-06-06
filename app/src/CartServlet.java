import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/cart")
@SuppressWarnings("serial")
public class CartServlet extends HttpServlet {
 
  public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    Integer id = Integer.parseInt(request.getParameter("id"));
    Integer qty = Integer.parseInt(request.getParameter("qty"));
    HttpSession sesh = request.getSession(true);
    HashMap<Integer, Integer> cart; 
    if(sesh.getAttribute("cart") != null){
      cart = (HashMap<Integer, Integer>) sesh.getAttribute("cart");
    }
    else {
      cart = new HashMap<Integer, Integer>();
    }

    if (cart.containsKey(id)){ 
      cart.put(id, cart.get(id)+qty);
    } else {
      cart.put(id, qty);
    }

    sesh.setAttribute("cart", cart);

    response.sendRedirect(request.getHeader("referer"));
  }
}
