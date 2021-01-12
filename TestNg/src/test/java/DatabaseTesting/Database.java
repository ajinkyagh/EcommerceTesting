package DatabaseTesting;

import java.sql.*;

public class Database {
    public static void main(String[] args) throws SQLException {
        String host="localhost";
        String port="3306";
        Connection con=DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/Qadb","root","admin");
        Statement s=con.createStatement();
        ResultSet rs=s.executeQuery("select * from Employeeinfo where name='ram';");
        while (rs.next()) {
            System.out.println(rs.getString("location"));
            System.out.println(rs.getString("age"));
        }
    }
}
