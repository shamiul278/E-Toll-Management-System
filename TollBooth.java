import java.sql.*;

public class TollBooth {

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/e_toll_management_system", "root", "");
             Statement st = conn.createStatement()) {

            System.out.println("connected");

            // Retrieve tollbooths
            try (ResultSet tollbooths = st.executeQuery("select * from tollbooths")) {
                while (tollbooths.next()) {
                    System.out.println("BoothID : " + tollbooths.getInt(1) +
                            " Location :" + tollbooths.getString(2) +
                            " Type : " + tollbooths.getInt(3) +
                            " LaneCount : " + tollbooths.getString(4) + 
                            " BoothID:" + tollbooths.getInt(5));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
