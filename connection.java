package library_management;

import java.sql.*;
import javax.sql.*;

public class connection {
    Connection conn = null;

    connection() {
        try {
            // Establish a connection
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "meseret369");

            if (conn!= null) {
                System.out.println("Connected to the PostgreSQL database!");
            }
            else {
            	System.out.println("not connected");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        
        
    }

    public int countbooks(String tableName) {
        int count = 0;
        try (Statement stmt = conn.createStatement()) {
            String query = "SELECT SUM(quantity) FROM " + tableName;
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        return count;
    }
    
    public int countstus(String tableName) {
        int count = 0;
        try (Statement stmt = conn.createStatement()) {
            String query = "SELECT COUNT(*) FROM " + tableName;
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        return count;
    }
    public int countissue(String tableName) {
        int count = 0;
        try (Statement stmt = conn.createStatement()) {
            String query = "SELECT count(*) FROM " + tableName+" WHERE status='issued';";
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
        }
        return count;
    }
    
    public void close() {
        try {
            if (conn!= null &&!conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}