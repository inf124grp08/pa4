import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.util.*;

import app.*;

@WebServlet("/product")
@SuppressWarnings("serial")
public class ProductServlet extends HttpServlet {
 
  private String message;

  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
            throws ServletException, IOException
  {
    RestHelper dh = new RestHelper();
    int id = Integer.parseInt(request.getParameter("id"));
    Product product = dh.getProduct(id);
    request.setAttribute("product", product);
    request.getRequestDispatcher("/navbar").include(request, response);
    // Create recently visted cookie
    // Read in the recently visited cookie list
    HttpSession sesh = request.getSession(true);
    Queue<Integer> RVs;
    String visited = "";
    if(sesh.getAttribute("visited") != null){
      RVs = (Queue<Integer>) sesh.getAttribute("visited");
    }
    else {
      RVs = new LinkedList<Integer>();
    }
    if(RVs.size() == 5){
      RVs.remove();
    }
    RVs.add(id);
    sesh.setAttribute("visited", RVs);
    request.getRequestDispatcher("/WEB-INF/product.jsp").forward(request, response);
  }
}
