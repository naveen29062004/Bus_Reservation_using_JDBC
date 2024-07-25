package busesv;
import java.sql.*;
import java.util.Date;
public class BookinDAO {
   public int getbookcount(int busno,Date date) throws SQLException{
       String query="select count(passanger_name) from booking where bus_no=? and travel_date=?";

       Connection con=DBConnection.getconnection();
       PreparedStatement p=con.prepareStatement(query);
       java.sql.Date sqldate=new java.sql.Date(date.getTime());
       p.setInt(1,busno);
       p.setDate(2,sqldate);
       ResultSet r=p.executeQuery();
       r.next();
       return r.getInt(1);



   }
   public void addBooking(Booking b) throws SQLException
   {
       String query="insert into booking values(?,?,?)";
       Connection con=DBConnection.getconnection();
       java.sql.Date sqldate=new java.sql.Date(b.date.getTime());
       PreparedStatement p=con.prepareStatement(query);
       p.setString(1,b.passangername);
       p.setInt(2,b.busno);
       p.setDate(3,sqldate);
       int v= p.executeUpdate();
       System.out.println(v);

   }

}
