<%-- 
    Document   : showAddRetailerItem
    Created on : Aug 2, 2024, 10:40:40?PM
    Author     : rosal
--%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Item - Food Waste Reduction Platform</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/styles.css" rel="stylesheet">
</head>
<body>
    
<%@ include file="header.jsp" %>
            
<div class="main">
    <div class="card p-4">
        <h2 class="text-center">Add New Item</h2>
        <form action="${pageContext.request.contextPath}/retailer/safe/addRetailerItemController" method="post">

            <div class="form-group">
                <label for="itemName">Item Name</label>
                <input type="text" class="form-control" id="itemName" name="itemName" required>
            </div>

            <div class="form-group">
                <label for="price">Price</label>
                <input type="text" class="form-control" id="price" name="price" required>
            </div>

            <div class="form-group">
                <label for="quantity">Quantity</label>
                <input type="number" class="form-control" id="quantity" name="quantity" required>
            </div>

            <div class="form-group">
                <label for="restockTime">Restock date</label>
                <input type="date" class="form-control" id="restockTime" name="restockTime" required>
            </div>

            <div class="form-group">
                <label for="expirationDate">Expiration date</label>
                <input type="date" class="form-control" id="expirationDate" name="expirationDate" required>
            </div>

            <div class="form-group">
                <label for="priceType">Price Type</label>
                <select class="form-control" id="priceType" name="priceType" required>
                    <option value="" disabled selected>Select a price type</option>
                    <option value="1">Donate</option>
                    <option value="2">Sales</option>
                </select>
            </div>

            <div class="form-group">
                <label for="isSurplus">Is Surplus</label>
                <select class="form-control" id="isSurplus" name="isSurplus" required>
                    <option value="" disabled selected>Select an option</option>
                    <option value="1">Yes</option>
                    <option value="2">No</option>
                </select>
            </div>

            <div class="text-center mt-3">
                <input type="submit" value="Add Item" class="btn btn-custom btn-block">
            </div>

            <div class="text-center mt-3">
                <a href="${pageContext.request.contextPath}/retailer/safe/showRetailerItemsController" class="btn btn-secondary btn-block">Go Back</a>
            </div>
        </form>
    </div>
</div>
    

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
