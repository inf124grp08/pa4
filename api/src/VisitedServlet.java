import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.sql.*;
import java.util.*;

import app.*;

@WebServlet("/visited")
@SuppressWarnings("serial")
public class VisitedServlet extends HttpServlet {

  private String message;

  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
            throws ServletException, IOException
  {
    DataHelper dh = new DataHelper(response.getWriter());

    HttpSession sess = request.getSession();
    if (sess != null) {
      Queue<Integer> q = (Queue<Integer>) sess.getAttribute("visited");
      if (q != null && q.size() > 0) {
        ArrayList<Integer> ids = new ArrayList(q);
        request.setAttribute("visitedProducts", dh.getProductList(ids));
      }
    }
  }
}
