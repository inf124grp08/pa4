import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.sql.*;
import java.util.*;

import app.*;

@WebServlet("/navbar")
@SuppressWarnings("serial")
public class NavbarServlet extends HttpServlet {

  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
            throws ServletException, IOException
  {
    DataHelper dh = new DataHelper(response.getWriter());
    HashMap<String,Category> categories = dh.getCategories();
    request.setAttribute("categories", categories.values());
    HttpSession sesh = request.getSession(true);
    HashMap<Integer, Integer> cart; 
    if(sesh.getAttribute("cart") != null){
      cart = (HashMap<Integer, Integer>) sesh.getAttribute("cart");
    }
    else {
      cart = new HashMap<Integer, Integer>();
    }


    int cartCount = 0;
    for (int qty : cart.values()) {
      cartCount += qty;
    }

    request.setAttribute("cartCount", cartCount);
  }
}
