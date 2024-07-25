import java.lang.reflect.Type;
import java.sql.*;
import java.util.Set;

public class jdbcdemo {
    public static void main(String[] args) throws SQLException{


     demo1();

    }
    public static void display() throws SQLException
    {
         String url="jdbc:mysql://localhost:3306/db";
        String username="root";
        String password="RSnk2004";
        String query="select * from employee";
        Connection con=DriverManager.getConnection(url,username,password);
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery(query);


        while (rs.next()) {
            System.out.println("id is " + rs.getInt(1));
            System.out.println("Name is " + rs.getString(2));
            System.out.println("salary is " + rs.getFloat(3));

        }

        con.close();
    }
     public static void insert() throws SQLException
    {
         String url="jdbc:mysql://localhost:3306/db";
        String username="root";
        String password="RSnk2004";
        int id=8;
        String name="krisika";
        double v =10;

//        String query="insert into employee values(5,'Naveen',9.0);"
        String query="insert into employee values(?,?,?);";
        Connection con=DriverManager.getConnection(url,username,password);
      PreparedStatement pr=con.prepareStatement(query);
      pr.setInt(1,id);
      pr.setString(2,name);
      pr.setDouble(3,v);
      int vi=pr.executeUpdate();
        System.out.println(vi);
        con.close();
    }
    public static void delete() throws SQLException{
        int id=3;
        String query="delete from employee where id=?";
        String url="jdbc:mysql://localhost:3306/db";
        String username="root";
        String password="RSnk2004";
        Connection con=DriverManager.getConnection(url,username,password);
        PreparedStatement pr=con.prepareStatement(query);
        pr.setInt(1,5);
        pr.executeUpdate();
        con.close();




    }
     public static void update() throws SQLException{
        int ide=3;

        String url="jdbc:mysql://localhost:3306/db";
        String username="root";
        String password="RSnk2004";

        Connection con=DriverManager.getConnection(url,username,password);
       CallableStatement cst=con.prepareCall("{call gets(?,?)}");
       cst.setInt(1,ide);
       cst.registerOutParameter(2, Types.VARCHAR);

       cst.executeUpdate();
         System.out.println(cst.getString(2));



        con.close();




    }
    public static void  call() throws SQLException{
        String url="jdbc:mysql://localhost:3306/db";
        String username="root";
        String password="RSnk2004";
        String query="select * from employee";
        Connection con=DriverManager.getConnection(url,username,password);
     Statement p=con.createStatement();
     ResultSet r=p.executeQuery(query);
     while(r.next())
     {
         System.out.println(r.getInt(1));
         System.out.println(r.getString(2));
         System.out.println(r.getFloat(3));

     }

    }
       public static void  demo() throws SQLException{
        String url="jdbc:mysql://localhost:3306/db";
        String username="root";
        String password="RSnk2004";




          String query="update employee set cgpa = 1.0 where id=1";
           String query1="updat employee set cgpa = 1.0 where id=2";
            Connection con=DriverManager.getConnection(url,username,password);
                con.setAutoCommit(false);
     Statement p=con.createStatement();
     int r=p.executeUpdate(query);
           System.out.println(r);


     int r1=p.executeUpdate(query1);
           System.out.println(r1);
     if(r>0 && r1>0)
     {
         con.commit();
     }


    }
      public static void  demo1() throws SQLException{
        String url="jdbc:mysql://localhost:3306/db";
        String username="root";
        String password="RSnk2004";




          String query="update employee set cgpa = 3.0 where id=1";
           String query1="update employee set cgpa = 3.0 where id=2";
             String query3="update employee set cgpa = 3.0 where id=3";
               String query4="update employee set cgpa = 3.0 where id=4";
            Connection con=DriverManager.getConnection(url,username,password);
            con.setAutoCommit(false);

     Statement p=con.createStatement();
     p.addBatch(query);
       p.addBatch(query1);
         p.addBatch(query3);
           p.addBatch(query4);
    int[] arr=p.executeBatch();
    for(int i:arr)
    {
        if(i>0) {
            System.out.print(i + " ");
        }
        else {
            con.rollback();
        }
    }
    con.commit();






    }
}
