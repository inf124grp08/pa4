import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import app.*;

@WebServlet("/checkout")
@SuppressWarnings("serial")
public class CheckoutServlet extends HttpServlet {
 
  public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    request.getRequestDispatcher("/navbar").include(request, response);

    HttpSession sesh = request.getSession(true);
    HashMap<Integer, Integer> cart; 
    if(sesh.getAttribute("cart") != null){
      cart = (HashMap<Integer, Integer>) sesh.getAttribute("cart");
    }
    else {
      cart = new HashMap<Integer, Integer>();
    }

    DataHelper dh = new DataHelper(response.getWriter());
    ArrayList<Integer> ids = new ArrayList<Integer>(cart.keySet());
    request.setAttribute("cartProducts", dh.getProductList(ids));
    request.setAttribute("cart", cart);

    request.getRequestDispatcher("/WEB-INF/checkout.jsp").forward(request, response);
  }
}
