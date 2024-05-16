import java.sql.*;

public class Vehicles {

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/e_toll_management_system", "root", "");
             Statement st = conn.createStatement()) {

            System.out.println("connected");

            // Retrieve vehicles
            try (ResultSet vehicles = st.executeQuery("select * from vehicles")) {
                while (vehicles.next()) {
                    System.out.println("LicensePlate = " + vehicles.getString(1) +
                            " VehiclesType = " + vehicles.getString(2) +
                            " UsersID = " + vehicles.getInt(3));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
