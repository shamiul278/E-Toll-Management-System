import java.sql.*;

public class Users {

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

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
