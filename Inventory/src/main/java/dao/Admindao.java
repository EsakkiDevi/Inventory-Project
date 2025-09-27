package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Admin;
import db.DBConnection;

public class Admindao {
    public boolean validate(Admin admin) {
        boolean status = false;
        try (Connection con = DBConnection.getConnection()) {
            String query = "SELECT * FROM admin_users WHERE username=? AND password=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, admin.getUsername());
            ps.setString(2, admin.getPassword());

            ResultSet rs = ps.executeQuery();
            status = rs.next();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
}
