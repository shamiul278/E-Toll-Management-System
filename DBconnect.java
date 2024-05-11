import java.sql.*;

public class DBconnect {

    public static void main(String[] args) {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/e_toll_management_system", "root", "");
            System.out.println("connected");
            Statement st = conn.createStatement();

            // Retrieve tollbooths
            ResultSet tollbooths = conn.createStatement().executeQuery("select * from tollbooths");
            while (tollbooths.next())
                System.out.println("BoothID = " + tollbooths.getInt(1) +
                        " Location = " + tollbooths.getString(2) +
                        " Type = " + tollbooths.getString(3) +
                        " LaneCount = " + tollbooths.getInt(4));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
