
/*
3.	Write a program to read value from the DB. The SB scheme is as follows:
a.	Username: root
b.	Password: root
c.	Table name: test
d.	Schema  
i.	Emp name varchar 200
ii.	Emp age int 10
*/


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class Problem3 {
    public static void main(String[] args) {
        // Database connection details
        String url = "jdbc:mysql://localhost:3306/sb"; // Replace 'sb' with your actual schema name
        String user = "root";
        String password = "root";

        // SQL query
        String query = "SELECT `Emp name`, `Emp age` FROM test";

        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            Connection conn = DriverManager.getConnection(url, user, password);

            // Create statement
            Statement stmt = conn.createStatement();

            // Execute query
            ResultSet rs = stmt.executeQuery(query);

            // Print results
            while (rs.next()) {
                String empName = rs.getString("Emp name");
                int empAge = rs.getInt("Emp age");

                System.out.println("Employee Name: " + empName + ", Age: " + empAge);
            }

            // Close resources
            rs.close();
            stmt.close();
            conn.close();

        } catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver not found. Add it to your classpath.");
        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
        }
    }
}
