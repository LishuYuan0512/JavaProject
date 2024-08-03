<%@page import="entity.FoodItem"%>
<%@page import="java.util.List"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Available Items - Food Waste Reduction Platform</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/styles.css" rel="stylesheet">
</head>
<body>
<%@ include file="header.jsp" %>

<div class="container mt-5">
    <h2 class="text-center">Available Items</h2>

    <table class="table table-hover table-bordered mt-4">
        <thead class="thead-dark">
        <tr>
            <th scope="col">Item ID</th>
            <th scope="col">Item Name</th>
            <th scope="col">Quantity</th>
            <th scope="col">Expiration Date</th>
            <th scope="col">Price Type</th>
            <th scope="col">Price</th>
            <th scope="col">Is Surplus</th>
        </tr>
        </thead>
        <tbody>
        <%
            List<FoodItem> foodItems = (List<FoodItem>) request.getAttribute("foodItems");

            if (foodItems != null && !foodItems.isEmpty()) {
                for (FoodItem foodItem : foodItems) {
        %>
        <tr>
            <td><%= foodItem.getItemID() %></td>
            <td><%= foodItem.getItemName() %></td>
            <td><%= foodItem.getQuantity() %></td>
            <td><%= foodItem.getExpirationDate() %></td>
            <td><%= foodItem.getPriceTypeID() == 1 ? "Donate" : "Sales" %></td>
            <td><%= foodItem.getPrice() %></td>
            <td><%= foodItem.getIsPlus() == 1 ? "Yes" : "No" %></td>
        </tr>
        <%
                }
            } else {
        %>
        <tr>
            <td colspan="7" class="text-center">No items available</td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
</div>

<%@ include file="footer.jsp" %>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
