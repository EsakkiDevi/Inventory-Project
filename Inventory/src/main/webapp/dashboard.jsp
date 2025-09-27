<%@ page import="java.util.*, dao.*, model.*" %>
<%@ page session="true" %>
<%
    String adminUser = (String) session.getAttribute("adminUser");
    if(adminUser == null) { response.sendRedirect("index.jsp"); return; }

    Productdao productDAO = new Productdao();
    Supplierdao supplierDAO = new Supplierdao();
    Orderdao orderDAO = new Orderdao();

    int productCount = productDAO.getTotalProducts();
    int supplierCount = supplierDAO.getTotalSuppliers();
    int orderCount = orderDAO.getTotalOrders();
    List<Product> lowStockProducts = productDAO.getLowStockProducts(5);
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Inventory Dashboard</title>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <style>
        body 
        { 
        font-family: Arial; 
        margin:0; 
        padding:0; 
        }
        header 
        { 
        background:#333; 
        color:#fff; 
        padding:10px; 
        display:flex; 
        justify-content:space-between; 
        }
        nav 
        { 
        background:#555; 
        color:#fff; 
        width:200px; 
        float:left; 
        height:100vh; 
        padding:10px; 
        }
        main 
        { 
        margin-left:210px; 
        padding:10px; 
        }
        .stats 
        { 
        display:flex; 
        gap:20px; 
        margin-bottom:20px; 
        }
        .card 
        { 
        background:#eee; 
        padding:15px; 
        border-radius:5px; 
        width:150px; 
        text-align:center; 
        }
        table 
        { 
        border-collapse: collapse; 
        width:100%; 
        }
        table, th, td 
        { 
        border:1px solid #ccc; 
        }
        th, td 
        { 
        padding:10px; 
        text-align:left; 
        }
        footer 
        { 
        background:#333; 
        color:#fff; 
        padding:10px; 
        text-align:center; 
        margin-top:20px; 
        clear:both;
        }
        a 
        { 
        color:#fff; 
        text-decoration:none; 
        }
    </style>
</head>
<body>
<header>
    <h2>Inventory Dashboard</h2>
    <div>Welcome, <%= adminUser %> | <a href="LogoutServlet">Logout</a></div>
</header>

<nav>
    <ul>
        <li><a href="dashboard.jsp">Dashboard</a></li>
        <li><a href="products.jsp">Products</a></li>
        <li><a href="suppliers.jsp">Suppliers</a></li>
        <li><a href="orders.jsp">Orders</a></li>
        <li><a href="reports.jsp">Reports</a></li>
    </ul>
</nav>

<main>
    <div class="stats">
        <div class="card"><h3>Products</h3><p><%= productCount %></p></div>
        <div class="card"><h3>Suppliers</h3><p><%= supplierCount %></p></div>
        <div class="card"><h3>Orders</h3><p><%= orderCount %></p></div>
    </div>

    <canvas id="pieChart" width="400" height="200"></canvas>

    <h3>Low Stock Products (≤5)</h3>
    <table>
        <tr><th>Name</th><th>SKU</th><th>Category</th><th>Quantity</th><th>Supplier</th></tr>
        <%
            for(Product p : lowStockProducts) {
        %>
        <tr>
            <td><%= p.getName() %></td>
            <td><%= p.getSku() %></td>
            <td><%= p.getCategory() %></td>
            <td><%= p.getQuantity() %></td>
            <td><%= p.getSupplierName() %></td>
        </tr>
        <%
            }
        %>
    </table>

    <script>
        const ctx = document.getElementById('pieChart').getContext('2d');
        const pieChart = new Chart(ctx, {
            type: 'pie',
            data: {
                labels: ['Products', 'Suppliers', 'Orders'],
                datasets: [{
                    data: [<%= productCount %>, <%= supplierCount %>, <%= orderCount %>],
                    backgroundColor: ['#FF6384','#36A2EB','#FFCE56']
                }]
            },
            options: { responsive: true }
        });
    </script>
</main>

<footer>&copy; 2025 Inventory Management</footer>
</body>
</html>
