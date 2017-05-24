import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.sql.*;
import java.util.*;

import app.*;

@WebServlet("/home")
@SuppressWarnings("serial")
public class HomeServlet extends HttpServlet {

  private String message;

  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
            throws ServletException, IOException
  {
    DataHelper dh = new DataHelper(response.getWriter());
    HashMap<String,Category> categories = dh.getCategories();
    request.setAttribute("categories", categories.values());
    request.getRequestDispatcher("/visited").include(request, response);

    request.getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
  }
}
