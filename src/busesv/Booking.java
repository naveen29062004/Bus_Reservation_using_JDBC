package busesv;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

class Booking {
     int busno;
  String passangername;
   Date date;

    Booking() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name of passanger: ");
        this.passangername = sc.nextLine(); // Use nextLine to allow spaces in names
        System.out.println("Enter bus no: ");
        this.busno = sc.nextInt();
        System.out.println("Enter date dd-MM-yyyy");
        String dateinput = sc.next();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
        try {
          date = dateFormat.parse(dateinput);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public boolean isAvailable() throws SQLException {
        BusDAO b = new BusDAO();
        BookinDAO ba = new BookinDAO();
        int capacity = b.getCapacity(busno);
        int booked = ba.getbookcount(busno, date);
        return booked < capacity;
    }
}
