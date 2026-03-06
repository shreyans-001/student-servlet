import java.sql.*;

public class Main{
    private static final String url="jdbc:mysql://localhost:3306/?user=bankk";
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

public class Bank_info {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/bankk";
        String user = "root";
        String password = "gietu";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);


            CallableStatement cs= con.prepareCall("{CALL  details()}");
            ResultSet rs = cs.executeQuery();



            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Age: " + rs.getInt("age"));
                System.out.println("Aadhar: " + rs.getInt("adharno"));
                System.out.println("PAN: " + rs.getInt("pan"));
                System.out.println("-------------------");
            }

            rs.close();
            cs.close();
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
