package app;
import java.io.*;
import java.sql.*;
import java.util.*;

public class DataHelper {
  PrintWriter pw;

  public DataHelper(PrintWriter pw) {
    this.pw = pw;
  }

  public void log(String text) {
    this.pw.println(text);
  }

  public HashMap<String,Category> getCategories() {
    HashMap<String,Category> categories = new HashMap<String,Category>();
    try {
      Connection conn = Database.getConnection();

      // Execute SQL query
      Statement stmt = conn.createStatement();
      String sql;
      sql = "SELECT * FROM categories;";
      ResultSet rs = stmt.executeQuery(sql);


      while(rs.next()){
        String name  = rs.getString("name");
        String label  = rs.getString("label");
        String description  = rs.getString("description");
        String image  = rs.getString("image");
        categories.put(name, new Category(name, label, description, image));
      }

      // Clean-up environment
      rs.close();
      stmt.close();
      conn.close();
    }catch(SQLException se){
      //Handle errors for JDBC

      pw.println("JDBC Error");
      pw.println(se.getMessage());
    }catch(Exception e){
      //Handle errors for Class.forName
      pw.println("Class.forName Error");
      pw.println(e.getMessage());

    }

    return categories;
  }


  public ArrayList<Product> getProducts(String catName) {
    ArrayList<Product> products = new ArrayList<Product>();
    try {
      Connection conn = Database.getConnection();

      // Execute SQL query
      String sql = "SELECT * FROM products WHERE category_id = ?";

      PreparedStatement ps = conn.prepareStatement(sql);

      ps.setString(1, catName);

      ResultSet rs = ps.executeQuery();

      while(rs.next()){

        int id = rs.getInt("id");
        String price = rs.getString("price");
        String brand = rs.getString("brand");
        String description = rs.getString("description");
        String image = rs.getString("image");

        products.add(new Product(id, price, brand,description, image));
      }

      // Clean-up environment
      rs.close();
      ps.close();
      conn.close();
    }catch(SQLException se){
      //Handle errors for JDBC

      pw.println("JDBC Error");
      pw.println(se.getMessage());
    }catch(Exception e){
      //Handle errors for Class.forName
      pw.println("Class.forName Error");
      pw.println(e.getMessage());

    }

    return products;
  }

  public Product getProduct(int id) {
    ArrayList<Integer> ids = new ArrayList<Integer>();
    ids.add(id);
    ArrayList<Product> products = getProductList(ids);
    return products.size() == 1 ? products.get(0) : null;
  }

  public ArrayList<Product> getProductList(ArrayList<Integer> ids) {
    ArrayList<Product> products = new ArrayList<Product>();

    try {
      Connection conn = Database.getConnection();

      // Execute SQL query
      String sql = "SELECT * FROM products WHERE";

      for (int i = 0; i < ids.size(); i++) {
        int id = ids.get(i);
        String suffix = "";
        if (i < ids.size()-1)
          suffix += " OR";
        sql+= " id = ?"+suffix;
      }

      PreparedStatement ps = conn.prepareStatement(sql);

      for (int i = 0; i < ids.size(); i++)
        ps.setInt(i+1, ids.get(i));

      ResultSet rs = ps.executeQuery();

      while(rs.next()){
        int id = rs.getInt("id");
        String price = rs.getString("price");
        String brand = rs.getString("brand");
        String description = rs.getString("description");
        String image = rs.getString("image");

        products.add(new Product(id, price, brand,description, image));
      }

      // Clean-up environment
      rs.close();
      ps.close();
      conn.close();
    }catch(SQLException se){
      //Handle errors for JDBC

      pw.println("JDBC Error");
      pw.println(se.getMessage());
    }catch(Exception e){
      //Handle errors for Class.forName
      pw.println("Class.forName Error");
      pw.println(e.getMessage());
    }

    return products;
  }

  public boolean submitOrder(HashMap<Integer,Integer> cart, HashMap<String, String> form) {

    try {
      Connection conn = Database.getConnection();

      for (int id : cart.keySet()) {
        int qty = cart.get(id);
        String sql = "INSERT INTO orders ( "
          +"product_id,"
          +"quantity,"
          +"firstname,"
          +"lastname,"
          +"phone,"
          +"address,"
          +"shipping,"
          +"creditcard,"
          +"expiry"
          +") VALUES (?,?,?,?,?,?,?,?,?);";

        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setInt(1, id);
        ps.setInt(2, qty);
        ps.setString(3, form.get("firstname"));
        ps.setString(4, form.get("lastname"));
        ps.setString(5, form.get("phone"));
        ps.setString(6, form.get("address"));
        ps.setString(7, form.get("shipping"));
        ps.setString(8, form.get("creditcard"));
        ps.setString(9, form.get("expiry"));

        ps.executeUpdate();
        ps.close();
      }

      conn.close();

      return true;
    }catch(SQLException se){
      //Handle errors for JDBC

      pw.println("JDBC Error");
      pw.println(se.getMessage());
    }catch(Exception e){
      //Handle errors for Class.forName
      pw.println("Class.forName Error");
      pw.println(e.getMessage());
    }

    return false;
  }
}
