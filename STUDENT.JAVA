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
        try {            Connection connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
    }
}
import java.sql.*;
import java.util.Scanner;
public class students {
    static final String URL = "jdbc:mysql://localhost:3306/stud";
    static final String USER = "root";
    static final String PASS = "gietu";
    public static void main(String[] args) {
        try (
                Connection con = DriverManager.getConnection(URL, USER, PASS);
                Scanner sc = new Scanner(System.in)
        ) {
            System.out.println("1. Insert Student");
            System.out.println("2. Get Student");
            System.out.println("3. Update Salary");
            System.out.println("4. Delete Student");
            System.out.print("Enter your choice: ");


            int choice = sc.nextInt();

            // INSERT
            if (choice == 1) {

                CallableStatement cs =
                        con.prepareCall("{call getinsert(?, ?, ?, ?)}");


                System.out.print("Enter ID: ");
                cs.setInt(1, sc.nextInt());

                System.out.print("Enter Name: ");
                cs.setString(2, sc.next());

                System.out.print("Enter Age: ");
                cs.setInt(3, sc.nextInt());

                System.out.print("Enter Salary: ");
                cs.setDouble(4, sc.nextDouble());

                cs.execute();
                System.out.println("Student Inserted");
            }


            // SELECT
            else if (choice == 2) {
                CallableStatement cs =
                        con.prepareCall("{call getnaameee(?, ?, ?, ?)}");

                System.out.print("Enter ID: ");
                cs.setInt(1, sc.nextInt());

                cs.registerOutParameter(2, Types.VARCHAR);
                cs.registerOutParameter(3, Types.INTEGER);
                cs.registerOutParameter(4, Types.DOUBLE); 

                cs.execute();

                System.out.println("Name   : " + cs.getString(2));
                System.out.println("Age    : " + cs.getInt(3));
                System.out.println("Salary : " + cs.getDouble(4));

            }


            // UPDATE
            else if (choice == 3) {
                CallableStatement cs =
                        con.prepareCall("{call getupdate(?, ?)}");

                System.out.print("Enter ID: ");
                cs.setInt(1, sc.nextInt());

                System.out.print("Enter New Salary: ");
                cs.setDouble(2, sc.nextDouble());

                cs.execute();
                System.out.println("Salary Updated");

            }


            // DELETE
            else if (choice == 4) {

                CallableStatement cs =
                        con.prepareCall("{call  getdelete(?)}");

                System.out.print("Enter ID: ");
                cs.setInt(1, sc.nextInt());

                cs.execute();
                System.out.println(" Student Deleted");

            }

            else {
                System.out.println(" Invalid choice");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
0 commit commentsComments0
