package busesv;

import java.sql.SQLException;
import java.util.*;

public class BusDemo {
    public static void main(String[] args) throws SQLException {
        BusDAO buddao=new BusDAO();
        buddao.displaybusinfo();
        int useropt=1;
        Scanner sc=new Scanner(System.in);
        while (useropt==1)
        {
            System.out.println("Enter 1 to Book and 2 to exit");
            useropt=sc.nextInt();
            if(useropt==1)
            {
                Booking b=new Booking();
                if(b.isAvailable())
                {
                    BookinDAO bi=new BookinDAO();
                    bi.addBooking(b);
                    System.out.println("Your booking is confirmed");
                }
                else {
                    System.out.println("Sorry. But is full. Try another bus or data");
                }
            }
            else {
                System.out.println("Thank you for visit our site");
            }
        }

    }
}
