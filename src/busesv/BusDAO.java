package busesv;

import java.sql.*;

public class BusDAO {

    public void displaybusinfo() throws SQLException {
        String query = "SELECT * FROM bus";
        try (Connection con = DBConnection.getconnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query)) {

            while (rs.next()) {
                int id = rs.getInt(1);
                System.out.println("Bus no: " + id);

                System.out.println("AC: " + (rs.getInt(2) == 0 ? "no" : "yes"));
                System.out.println("Capacity: " + rs.getInt(3));
                displayAvailability(id);
            }
            System.out.println("-----------------------------------------------");
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public void displayAvailability(int busId) throws SQLException {
        String query1 = "SELECT capacity FROM bus WHERE id = ?";
        String query2 = "SELECT COUNT(*) FROM booking WHERE bus_no = ?";

        try (Connection con = DBConnection.getconnection();
             PreparedStatement ps1 = con.prepareStatement(query1);
             PreparedStatement ps2 = con.prepareStatement(query2)) {

            ps1.setInt(1, busId);
            try (ResultSet rs1 = ps1.executeQuery()) {
                if (rs1.next()) {
                    int capacity = rs1.getInt(1);

                    ps2.setInt(1, busId);
                    try (ResultSet rs2 = ps2.executeQuery()) {
                        if (rs2.next()) {
                            int bookedSeats = rs2.getInt(1);
                            int availableSeats = capacity - bookedSeats;

                            if (availableSeats > 0) {
                                System.out.println("The available seats are: " + availableSeats);
                            } else {
                                System.out.println("No available seats in this bus.");
                            }
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public int getCapacity(int busId) throws SQLException {
        String query = "SELECT capacity FROM bus WHERE id = ?";
        try (Connection con = DBConnection.getconnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, busId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1);
                } else {
                    throw new SQLException("Bus with id " + busId + " not found.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }
}
