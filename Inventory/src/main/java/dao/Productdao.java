package dao;

import java.sql.*;
import java.util.*;
import model.Product;
import db.DBConnection; 

public class Productdao {

    // Total products
    public int getTotalProducts() {
        int count = 0;
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM products")) {

            if (rs.next()) count = rs.getInt(1);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    // Low stock products (threshold)
    public List<Product> getLowStockProducts(int threshold) {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT p.productId, p.name, p.sku, p.category, p.price, p.quantity, s.name AS supplierName " +
                     "FROM products p LEFT JOIN suppliers s ON p.supplierId = s.supplierId " +
                     "WHERE p.quantity <= ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, threshold);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                Product p = new Product();
                p.setProductId(rs.getInt("productId"));
                p.setName(rs.getString("name"));
                p.setSku(rs.getString("sku"));
                p.setCategory(rs.getString("category"));
                p.setPrice(rs.getDouble("price"));
                p.setQuantity(rs.getInt("quantity"));
                // Add supplier name if needed
                list.add(p);
            }

        } catch(SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
