import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectDB {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/happybasket"; // Database name
        String user = "root"; // MySQL username
        String password = "Renuga@24"; // MySQL password

        try {
            // 1. Load MySQL Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Connect to DB
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("✅ Connected to MySQL successfully!");

            // ============================
            // INSERT USER
            // ============================
            String insertUser = "INSERT INTO users (name, email, password) VALUES (?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(insertUser);
            pstmt.setString(1, "Kavya");
            pstmt.setString(2, "kavya@example.com");
            pstmt.setString(3, "mypassword123");
            pstmt.executeUpdate();
            pstmt.close();
            System.out.println("👤 User added!");

            // ============================
            // INSERT PRODUCT
            // ============================
            String insertProduct = "INSERT INTO products (name, price, stock) VALUES (?, ?, ?)";
            PreparedStatement pstmt2 = conn.prepareStatement(insertProduct);
            pstmt2.setString(1, "Rose Bouquet");
            pstmt2.setDouble(2, 499.99);
            pstmt2.setInt(3, 20);
            pstmt2.executeUpdate();
            pstmt2.close();
            System.out.println("🌹 Product added!");

            // ============================
            // INSERT INTO CART
            // ============================
            String insertCart = "INSERT INTO cart (user_id, product_id, quantity) VALUES (?, ?, ?)";
            PreparedStatement pstmt3 = conn.prepareStatement(insertCart);
            pstmt3.setInt(1, 1); // user_id = 1 (Kavya)
            pstmt3.setInt(2, 1); // product_id = 1 (Rose Bouquet)
            pstmt3.setInt(3, 2); // quantity
            pstmt3.executeUpdate();
            pstmt3.close();
            System.out.println("🛒 Cart updated!");

            // ============================
            // SHOW USERS
            // ============================
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM users");
            System.out.println("\n👤 Users:");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " | " + rs.getString("name") + " | " + rs.getString("email"));
            }
            rs.close();

            // ============================
            // SHOW PRODUCTS
            // ============================
            ResultSet rs2 = stmt.executeQuery("SELECT * FROM products");
            System.out.println("\n🌸 Products:");
            while (rs2.next()) {
                System.out.println(rs2.getInt("id") + " | " + rs2.getString("name") +
                                   " | ₹" + rs2.getDouble("price") +
                                   " | stock: " + rs2.getInt("stock"));
            }
            rs2.close();

            // ============================
            // SHOW CART
            // ============================
            ResultSet rs3 = stmt.executeQuery(
                "SELECT c.id, u.name, p.name AS product, c.quantity " +
                "FROM cart c " +
                "JOIN users u ON c.user_id = u.id " +
                "JOIN products p ON c.product_id = p.id"
            );
            System.out.println("\n🛒 Cart:");
            while (rs3.next()) {
                System.out.println("Cart ID " + rs3.getInt("id") + " | " +
                                   rs3.getString("name") + " bought " +
                                   rs3.getInt("quantity") + " x " +
                                   rs3.getString("product"));
            }
            rs3.close();

            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
    