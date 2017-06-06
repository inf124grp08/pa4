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

  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
            throws ServletException, IOException
  {
    request.getRequestDispatcher("/navbar").include(request, response);
    request.getRequestDispatcher("/visited").include(request, response);
    request.getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
  }
}
