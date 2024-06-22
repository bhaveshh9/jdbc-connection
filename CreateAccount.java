package dbtest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.Scanner;
public class CreateAccount {
    void create(){
     Scanner s=new Scanner(System.in);
        System.out.println("Enter your Name");
        String cname=s.nextLine();
        System.out.println("Enter your mobile number");
        String cmob=s.nextLine();
        System.out.println("Enter your City");
        String ccity=s.nextLine();
        System.out.println("Enter your Balance");
        int cbal=s.nextInt();
        Connection con=Dbconnection.connect();
       try{
        PreparedStatement pstmt=con.prepareStatement("INSERT INTO customers (cname, cmob, ccity, cbal) VALUES (?, ?, ?, ?)");
        pstmt.setString(1,cname);
        pstmt.setString(2,cmob);
        pstmt.setString(3,ccity);
        pstmt.setInt(4,cbal);
        int i=pstmt.executeUpdate();
        if(i>0)
        {
            System.out.println("Insert successfully");
        }}
       catch (SQLException e)
       {
           e.printStackTrace();
       }
    }



}
