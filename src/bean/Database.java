package bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Database {
	
	// Queries the database and returns a result set
    public static ResultSet queryDatabase(String query) {
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            // change string inside getConnection to fit your db
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/webapde?user=root&password=root");
            Statement stmt = (Statement) conn.createStatement();
            stmt.executeQuery(query);
            rs = stmt.getResultSet();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return rs;
    }

    // Updates a database with new rows.
    public static void updateDatabase(String query) {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            // change string inside getConnection to fit your db
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/webapde?user=root&password=root");
            Statement stmt = (Statement) conn.createStatement();
            stmt.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
