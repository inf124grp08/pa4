import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.util.*;
import java.sql.*;

import app.*;

@WebServlet("/category")
@SuppressWarnings("serial")
public class CategoryServlet extends HttpServlet {

  private String message;

  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
            throws ServletException, IOException
  {
    String name = request.getParameter("name");
    DataHelper dh = new DataHelper(response.getWriter());
    HashMap<String,Category> categories = dh.getCategories();
    ArrayList<Product> products = dh.getProducts(name);
    request.setAttribute("products", products);
    request.setAttribute("categories", categories.values());
    request.setAttribute("category", categories.get(name));
    request.getRequestDispatcher("/navbar").include(request, response);
    request.getRequestDispatcher("/WEB-INF/category.jsp").forward(request, response);
  }
}
