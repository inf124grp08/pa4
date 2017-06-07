package api;
import java.sql.*;

public class Database {
    static final String JDBC_DRIVER="com.mysql.jdbc.Driver";  
    static final String DB_URL="jdbc:mysql://sylvester-mccoy-v3.ics.uci.edu/inf124-db-048";
    static final String USER = "inf124-db-048";
    static final String PASS = "VFkDk@1E_VRs";

    public static Connection getConnection() throws Exception {

      // Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      // Open a connection
      return DriverManager.getConnection(DB_URL, USER, PASS);
    }
}
