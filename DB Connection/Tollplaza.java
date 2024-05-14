import java.sql.*;

public class Tollplaza {

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/e_toll_management_system", "root", "");
             Statement st = conn.createStatement()) {

            System.out.println("connected");

            // Retrieve tollplaza
            try (ResultSet tollplaza = st.executeQuery("select * from tollplaza")) {
                while (tollplaza.next()) {
                    System.out.println("PlazaID = " + tollplaza.getInt(1) +
                            " Date = " + tollplaza.getString(2));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
