import java.sql.*;

public class ToothBooth {

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/e_toll_management_system", "root", "");
             Statement st = conn.createStatement()) {

            System.out.println("connected");

            // Retrieve toothbooths
            try (ResultSet toothbooths = st.executeQuery("select * from toothbooths")) {
                while (toothbooths.next()) {
                    System.out.println("BoothID : " + toothbooths.getInt(1) +
                            " Location :" + toothbooths.getString(2) +
                            " Type : " + toothbooths.getInt(3) +
                            " LaneCount : " + toothbooths.getString(4) + " BoothID:" + toothbooths.getInt(5));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
