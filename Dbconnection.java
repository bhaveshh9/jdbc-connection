package dbtest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Dbconnection {
 static Connection connect() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pranav", "root", "");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("error is occured");
        }
        return (con);
    }
}
