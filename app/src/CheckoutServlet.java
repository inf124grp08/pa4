import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.sql.*;

import app.*;

@WebServlet("/checkout")
@SuppressWarnings("serial")
public class CheckoutServlet extends HttpServlet {
 
  public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    HttpSession sesh = request.getSession(true);
    HashMap<Integer, Integer> cart; 
    if(sesh.getAttribute("cart") != null){
      cart = (HashMap<Integer, Integer>) sesh.getAttribute("cart");
    }
    else {
      cart = new HashMap<Integer, Integer>();
    }

    RestHelper dh = new RestHelper();
    ArrayList<Integer> ids = new ArrayList<Integer>(cart.keySet());
    request.setAttribute("cartProducts", dh.getProductList(ids));
    request.setAttribute("cart", cart);


    double totalPrice = 0;
    for (int id : cart.keySet()) {
      int qty = cart.get(id);

      Product product = dh.getProduct(id);
      totalPrice += qty * Double.parseDouble(product.getPrice());
    }

    request.setAttribute("totalPrice", Math.round(totalPrice*100)/100.0);
    request.getRequestDispatcher("/navbar").include(request, response);
    request.getRequestDispatcher("/WEB-INF/checkout.jsp").forward(request, response);
  }

  public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    RestHelper dh = new RestHelper();

    HashMap<String, String> form = new HashMap<String,String>();

    form.put("firstname", request.getParameter("firstname"));
    form.put("lastname", request.getParameter("lastname"));
    form.put("phone", request.getParameter("phone-number"));
    form.put("address", ""+
        request.getParameter("street") + " \n"+
        request.getParameter("city") + ", "+
        request.getParameter("state") + ", "+
        request.getParameter("zip")
        );
    form.put("shipping", request.getParameter("shipping"));
    form.put("creditcard", ""+
        request.getParameter("creditCard1") + "-"+
        request.getParameter("creditCard2") + "-"+
        request.getParameter("creditCard3") + "-"+
        request.getParameter("creditCard4")
        );
    form.put("expiry", request.getParameter("expiry"));

    HttpSession sesh = request.getSession(true);
    HashMap<Integer, Integer> cart = (HashMap<Integer, Integer>) sesh.getAttribute("cart");

    if (dh.submitOrder(cart, form)) {
      request.setAttribute("lastCart", cart);
      sesh.removeAttribute("cart");
      request.setAttribute("form", form);

      ArrayList<Integer> ids = new ArrayList<Integer>(cart.keySet());
      request.setAttribute("cartProducts", dh.getProductList(ids));

      double totalPrice = 0;
      for (int id : cart.keySet()) {
        int qty = cart.get(id);

        Product product = dh.getProduct(id);
        totalPrice += qty * Double.parseDouble(product.getPrice());
      }

      request.setAttribute("totalPrice", Math.round(totalPrice*100)/100.0);
      request.getRequestDispatcher("/WEB-INF/order.jsp").forward(request, response);
    } else {
    }
  }
}
