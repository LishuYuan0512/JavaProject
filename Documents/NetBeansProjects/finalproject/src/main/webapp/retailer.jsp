<%-- 
    Document   : retailer
    Created on : Jul 27, 2024, 11:03:19 AM
    Author     : tangy
--%>


<%@page import="com.mycompany.finalproject.FoodItem"%>
<%@page import="java.util.List"%>
<!--<!DOCTYPE html>
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
                        <th>Price Type</th>
                        <th>Price</th>
                        <th>Is Surplus</th>
                        <th>Option</th>
                    </tr>
                </thead>
                <tbody>
                   <c:forEach var="item" items="${foodItems}">
                <tr>
            <td>${item.itemID}</td>
            <td>${item.itemName}</td>
            <td>${item.quantity}</td>
            <td>${item.expirationDate}</td>
            <td>${item.priceType}</td>
            <td>${item.price}</td>
            <td>${item.isSurplus}</td>
            <td>
                <a href="retailer?action=update&itemID=${item.itemID}">Edit</a>
                <a href="retailer?action=delete&itemID=${item.itemID}">Delete</a>
                <a href="retailer?action=markAsSurplus&itemID=${item.itemID}">Surplus</a>
            </td>
        </tr>
    </c:forEach>
</tbody>
            </table>
            <button class="btn btn-custom" onclick="window.location.href='add-item.jsp'">Add Item</button>
        </div>
    </div>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>-->


<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Retailer - List Food Items</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <h2 class="text-center">Food Items List</h2>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>Item ID</th>
                    <th>Item Name</th>
                    <th>Quantity</th>
                    <th>Expiration Date</th>
                    <th>Price Type</th>
                    <th>Price</th>
                </tr>
            </thead>
            <tbody>
                <% 
                    List<FoodItem> foodItems = (List<FoodItem>) request.getAttribute("foodItems");
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
                </tr>
                <% 
                        }
                    } else {
                %>
                <tr>
                    <td colspan="6">No food items available</td>
                </tr>
                <% 
                    }
                %>
            </tbody>
        </table>
    </div>
</body>
</html>

