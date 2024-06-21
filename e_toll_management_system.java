import java.sql.*;

public class e_toll_management_system {

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/e_toll_management_system", "root", "");
             Statement st = conn.createStatement()) {

            System.out.println("connected");

            // Retrieve users
            try (ResultSet users = st.executeQuery("select * from users")) {
                while (users.next()) {
                    System.out.println("UsersID = " + users.getInt(1) +
                            " Name = " + users.getString(2) +
                            " Email = " + users.getString(3) +
                            " AddressType = " + users.getString(4) +
                            " Phone = " + users.getInt(5));
                }
                System.out.println("-----------------------------------------------");
            }

            // Retrieve vehicles
            try (ResultSet vehicles = st.executeQuery("select * from vehicles")) {
                while (vehicles.next()) {
                    System.out.println("LicensePlate = " + vehicles.getString(1) +
                            " VehiclesType = " + vehicles.getString(2) +
                            " UsersID = " + vehicles.getInt(3));
                }
                System.out.println("-----------------------------------------------");
            }

            // Retrieve transactions
            try (ResultSet transactions = st.executeQuery("select * from transactions")) {
                while (transactions.next()) {
                    System.out.println("TransactionID: " + transactions.getInt(1) +
                            " Timestamp: " + transactions.getString(2) +
                            " Amount: " + transactions.getInt(3) +
                            " LicensePlate: " + transactions.getString(4) +
                            " BoothID: " + transactions.getInt(5));
                }
                System.out.println("-----------------------------------------------");
            }

            // Retrieve tollbooths
            try (ResultSet tollbooths = st.executeQuery("select * from tollbooths")) {
                while (tollbooths.next()) {
                    System.out.println("BoothID : " + tollbooths.getInt(1) +
                            " Location : " + tollbooths.getString(2) +
                            " Type : " + tollbooths.getInt(3) +
                            " LaneCount : " + tollbooths.getInt(4));
                }
                System.out.println("-----------------------------------------------");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
