<%-- 
    Document   : retailer
    Created on : Jul 27, 2024, 11:03:19 AM
    Author     : tangy
--%>


<%@page import="project.FoodItem"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Retailer - XXX Website</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link href="styles.css" rel="stylesheet">
</head>
<body>
    <div class="header">
        <span>xxx website</span>
        <div>
            <a href="login.jsp" class="text-white">Log out</a>
        </div>
    </div>
    <div class="main">
        <div class="container">
            <h2 class="text-center">Welcome Retailer</h2>
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>Item ID</th>
                        <th>Item Name</th>
                        <th>Quantity</th>
                        <th>Expiration Date</th>
                        <th>Price Type ID</th>
                        <th>Price</th>
                        <th>Option</th>
                    </tr>
                </thead>
                <tbody>
                <% 
                    List<FoodItem> foodItems = (List<FoodItem>) request.getAttribute("items");
                    if (foodItems != null) {
                        for (FoodItem item : foodItems) {
                %>
                <tr>
                    <td><%= item.getItemID() %></td>
                    <td><%= item.getItemName() %></td>
                    <td><%= item.getQuantity() %></td>
                    <td><%= item.getExpirationDate() %></td>
                    <td><%= item.getPriceTypeID() %></td>
                    <td><%= item.getPrice() %></td>
                    <td>
                        <button class="btn btn-warning" onclick="editItem(<%= item.getItemID() %>)">Edit</button>
                        <button class="btn btn-danger" onclick="deleteItem(<%= item.getItemID() %>)">Delete</button>
                    </td>
                </tr>
                <% 
                        }
                    } else {
                %>
                <tr>
                    <td colspan="7">No food items available</td>
                </tr>
                <% 
                    }
                %>
                </tbody>
            </table>
            <button class="btn btn-custom" onclick="window.location.href='add-item.jsp'">Add Item</button>
        </div>
    </div>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script>
        function editItem(itemID) {
            window.location.href = 'edit-item.jsp?id=' + itemID;
        }

        function deleteItem(itemID) {
            if (confirm('Are you sure you want to delete this item?')) {
                window.location.href = 'delete-item.jsp?id=' + itemID;
            }
        }
    </script>
</body>
</html>
