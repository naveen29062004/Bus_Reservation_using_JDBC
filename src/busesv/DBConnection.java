package busesv;
import java.sql.*;


public class DBConnection {

         private static String url="jdbc:mysql://localhost:3306/busresv";
       private static String username="root";
        private static String password="RSnk2004";
       public  static Connection getconnection() throws SQLException
        {
            return DriverManager.getConnection(url,username,password);
        }
}
