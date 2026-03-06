import java.sql.*;
public class Main{
    private static final String url="jdbc:mysql://localhost:3306/?user=root";
    private static final String username="root";
    private static final String password="gietu";
    public static void main(String args[]) {
//        try{
//            Class.forName("com.mysql.cj.jdbc.Driver");
//        }
//        catch(ClassNotFoundException e){
//            System.out.println(e.getMessage());
//        }
//    }
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
    }
}

import java.sql.*;

public class allCustomerOrderProduct {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/data";
        String user = "root";
        String password = "gietu";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);

            // Total Orders
            CallableStatement cs1 = con.prepareCall("{CALL  gettotal()}");
            ResultSet rs1 = cs1.executeQuery();

            while(rs1.next()) {
                System.out.println("Total Orders = " + rs1.getInt(1));
            }

            // Customer Names
            CallableStatement cs2 = con.prepareCall("{CALL getcustomernames()}");
            ResultSet rs2 = cs2.executeQuery();

            System.out.println("Customers Who Ordered:");
            while(rs2.next()) {
                System.out.println(rs2.getString(1));
            }

            // Customers > 1 Item
            CallableStatement cs3 = con.prepareCall("{CALL   getiteam()}");
            ResultSet rs3 = cs3.executeQuery();

            while(rs3.next()) {
                System.out.println("Customers Ordered More Than One Item = " + rs3.getInt(1));
            }

            con.close();

        } catch(Exception e) {
            System.out.println(e);
        }
    }
}
