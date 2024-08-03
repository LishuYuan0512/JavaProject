
<%@ page import="entity.FoodItem" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page import="javax.servlet.http.HttpServletRequest" %>
<%
    FoodItem foodItem = (FoodItem) request.getAttribute("foodItem");
    if (foodItem == null) {
%>
    <p>Item not found.</p>
    <a href="<%= request.getContextPath() %>/retailer/safe/showRetailerItemsController" class="btn btn-secondary">Back</a>
<%
        return;
    }
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Item - Food Waste Reduction Platform</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%= request.getContextPath() %>/styles.css" rel="stylesheet">
</head>
<body>
<%@ include file="header.jsp" %>
<div class="container">
    <h2 class="text-center">Edit Item</h2>
    <form action="<%= request.getContextPath() %>/retailer/safe/editRetailerItemsController" method="post">
        <div class="form-group">
            <input type="hidden" class="form-control" id="itemID" name="itemID" value="<%= foodItem.getItemID() %>">
        </div>
        <div class="form-group">
            <label for="itemName">Item Name</label>
            <input type="text" class="form-control" id="itemName" name="itemName" value="<%= foodItem.getItemName() %>" readonly>
        </div>
        <div class="form-group">
            <label for="price">Price</label>
            <input type="text" class="form-control" id="price" name="price" value="<%= foodItem.getPrice() %>" readonly>
        </div>
        <div class="form-group">
            <label for="quantity">Quantity</label>
            <input type="number" class="form-control" id="enterQuantity" name="enterQuantity" placeholder="Enter replenishment quantity" min="1" required>
        </div>
        <div class="form-group">
            <label for="expirationData">Expiration date</label>
            <input type="date" class="form-control" id="expirationData" name="expirationData" placeholder="Expiration date" required>
        </div>
        <div class="text-center mt-3">
            <input type="submit" value="Update Item" class="btn btn-custom btn-block">
        </div>
    </form>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
