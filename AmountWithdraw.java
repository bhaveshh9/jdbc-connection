package dbtest;
import java.sql.*;
import java.util.Scanner;
public class AmountWithdraw {
    void withdraw() {
        Scanner s = new Scanner(System.in);
        Connection con = Dbconnection.connect();
        System.out.println("Enter your Cid");
        int cid = s.nextInt();
        System.out.println("Enter your amount to Withdraw");
        int newBal = s.nextInt();
        int oldBal = 0;
        try {
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM customers WHERE id=?");
            pstmt.setInt(1, cid);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                oldBal = rs.getInt(5);
                newBal = oldBal - newBal;
                System.out.println("new Bal = " + newBal);
            }
            PreparedStatement pstmt2 = con.prepareStatement("UPDATE customers SET cbal=?,id=?");
            pstmt2.setInt(1, newBal);
            pstmt2.setInt(2, cid);
            int i = pstmt2.executeUpdate();
            if (i > 0) {
                System.out.println("Your amount Deposit Successfully" + newBal);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
