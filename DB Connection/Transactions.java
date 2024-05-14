import java.sql.*;

public class Transactions {

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/e_toll_management_system", "root", "");
             Statement st = conn.createStatement()) {

            System.out.println("connected");

            // Retrieve transactions
            try (ResultSet transactions = st.executeQuery("select * from transactions")) {
                while (transactions.next()) {
                    System.out.println("TransactionID: " + transactions.getInt(1) +
                            " Timestamp:" + transactions.getString(2) +
                            " Amount: " + transactions.getInt(3) +
                            " LicensePlate: " + transactions.getString(4) + " BoothID:" + transactions.getInt(5));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
