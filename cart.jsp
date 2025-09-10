<%@ page import="java.sql.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>🛒 Your Cart - HappyBasket</title>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap" rel="stylesheet">
    <style>
        body { font-family: 'Poppins', sans-serif; background: rgb(225,192,203); margin: 0; padding: 20px;}
        h1 { text-align: center; color: #d81b60; }
        table { width: 80%; margin: 20px auto; border-collapse: collapse; background: white; box-shadow: 0 2px 8px rgba(0,0,0,0.1);}
        th, td { padding: 15px; text-align: center; border-bottom: 1px solid #ddd; }
        th { background-color: rgb(235, 169, 209); color: #444; }
        input[type=number] { width: 50px; padding: 5px; }
        .btn { padding: 8px 12px; border: none; border-radius: 5px; cursor: pointer; font-size: 14px; margin: 2px; }
        .btn-update { background-color: #d81b60; color: white; }
        .btn-remove { background-color: #e74c3c; color: white; }
        .cart-total { text-align: right; margin-right: 10%; font-size: 18px; font-weight: bold; }
        .cart-actions { text-align: center; margin-top: 20px; }
        .btn-checkout { background:#d81b60; color: white; font-size: 16px; padding: 12px 20px; }
    </style>
</head>
<body>

<h1>🛒 Your Cart</h1>

<%
    // ======== JDBC Connection ========
    String url = "jdbc:mysql://localhost:3306/happybasket";
    String user = "root";
    String password = "Renuga@24";
    int userId = 1; // hardcoded user ID for example

    double grandTotal = 0;

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(url, user, password);
        Statement stmt = conn.createStatement();

        String query = "SELECT c.id AS cart_id, p.name, p.price, c.quantity " +
                       "FROM cart c JOIN products p ON c.product_id = p.id " +
                       "WHERE c.user_id=" + userId;
        ResultSet rs = stmt.executeQuery(query);
%>

<table>
    <tr>
        <th>Product</th>
        <th>Price</th>
        <th>Quantity</th>
        <th>Total</th>
        <th>Action</th>
    </tr>

<%
        while(rs.next()) {
            int cartId = rs.getInt("cart_id");
            String productName = rs.getString("name");
            double price = rs.getDouble("price");
            int qty = rs.getInt("quantity");
            double total = price * qty;
            grandTotal += total;
%>
    <tr>
        <td><%= productName %></td>
        <td>₹<%= price %></td>
        <td><input type="number" value="<%= qty %>" min="1"></td>
        <td>₹<%= total %></td>
        <td>
            <button class="btn btn-update">Update</button>
            <button class="btn btn-remove">Remove</button>
        </td>
    </tr>
<%
        } // end while
        rs.close();
        stmt.close();
        conn.close();
%>
</table>

<div class="cart-total">Grand Total: ₹<%= grandTotal %></div>
<div class="cart-actions">
    <button class="btn btn-checkout">Proceed to Checkout</button>
</div>

<%
    } catch(Exception e) {
        out.println("<p style='color:red;text-align:center;'>Error: " + e.getMessage() + "</p>");
        e.printStackTrace();
    }
%>

</body>
</html>
