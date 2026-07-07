/*
6.	Write a HTTP server program that take the print the received value
 read from the DB as per Q3
*/

import com.sun.net.httpserver.*;
import java.io.*;
import java.net.InetSocketAddress;
import java.sql.*;

public class Question6 {
    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/employees", exchange -> {
            StringBuilder response = new StringBuilder();
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery("SELECT `Emp name`, `Emp age` FROM test")) {
                while (rs.next()) {
                    response.append(rs.getString("Emp name")).append(" - ").append(rs.getInt("Emp age")).append("\n");
                }
            } catch (Exception e) {
                response.append("Error: ").append(e.getMessage());
            }
            exchange.sendResponseHeaders(200, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.toString().getBytes());
            os.close();
        });
        server.start();
        System.out.println("Server started at http://localhost:8080/employees");
    }
}

/*
Server responds with DB rows.

Empty DB → empty response.

Wrong DB credentials → error.
*/

//TIME TAKEN: 35MIN
