package dao;
import java.sql.*;
import db.DBConnection;

public class Orderdao {
    public int getTotalOrders() {
        int count = 0;
        try(Connection conn = DBConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM orders")) {
            if(rs.next()) count = rs.getInt(1);
        } catch(SQLException e) { e.printStackTrace(); }
        return count;
    }
}
