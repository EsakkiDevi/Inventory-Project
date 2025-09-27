package dao;
import java.sql.*;
import db.DBConnection;

public class Supplierdao {
    public int getTotalSuppliers() {
        int count = 0;
        try(Connection conn = DBConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM suppliers")) {
            if(rs.next()) count = rs.getInt(1);
        } catch(SQLException e) { e.printStackTrace(); }
        return count;
    }
}
