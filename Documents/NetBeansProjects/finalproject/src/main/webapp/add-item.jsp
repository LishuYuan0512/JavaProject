<%-- 
    Document   : add-item
    Created on : Jul 27, 2024, 11:02:18 AM
    Author     : tangy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add/Edit Item - XXX Website</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link href="styles.css" rel="stylesheet">
</head>
<body>
    <div class="header">
        <span>xxx website</span>
        <div>
            <a href="retailer?action=list" class="text-white">Back</a>
        </div>
    </div>
    <div class="main">
        <div class="container">
            <h2 class="text-center">${foodItem == null ? 'Add' : 'Edit'} Item</h2>
            <form action="retailer" method="post">
                <input type="hidden" name="action" value="${foodItem == null ? 'add' : 'update'}">
                <input type="hidden" name="itemID" value="${foodItem != null ? foodItem.itemID : ''}">
                <div class="form-group">
                    <label for="itemName">Item Name</label>
                    <input type="text" class="form-control" id="itemName" name="itemName" placeholder="Enter item name" value="${foodItem != null ? foodItem.itemName : ''}">
                </div>
                <div class="form-group">
                    <label for="quantity">Quantity</label>
                    <input type="number" class="form-control" id="quantity" name="quantity" placeholder="Enter quantity" value="${foodItem != null ? foodItem.quantity : ''}">
                </div>
                <div class="form-group">
                    <label for="expirationDate">Expiration Date</label>
                    <input type="date" class="form-control" id="expirationDate" name="expirationDate" value="${foodItem != null ? foodItem.expirationDate : ''}">
                </div>
                <div class="form-group">
                    <label for="priceType">Price Type</label>
                    <select class="form-control" id="priceType" name="priceTypeID">
                        <option value="">Select</option>
                        <c:forEach var="priceType" items="${priceTypes}">
                            <option value="${priceType.priceTypeID}" ${foodItem != null && foodItem.priceTypeID == priceType.priceTypeID ? 'selected' : ''}>${priceType.priceType}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label for="price">Price</label>
                    <input type="text" class="form-control" id="price" name="price" placeholder="Enter price" value="${foodItem != null ? foodItem.price : ''}">
                </div>
                <div class="form-group">
                    <label for="isSurplus">Is Surplus</label>
                    <select class="form-control" id="isSurplus" name="isSurplus">
                        <option value="true" ${foodItem != null && foodItem.isSurplus ? 'selected' : ''}>Yes</option>
                        <option value="false" ${foodItem != null && !foodItem.isSurplus ? 'selected' : ''}>No</option>
                    </select>
                </div>
                <div class="text-center mt-3">
                    <button type="submit" class="btn btn-custom btn-block">Save</button>
                </div>
            </form>
        </div>
    </div>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>-->

<%-- 
    Document   : add-item
    Created on : Jul 27, 2024, 11:02:18 AM
    Author     : tangy
--%>

<%-- 
    Document   : add-item
    Created on : Jul 27, 2024, 11:02:18 AM
    Author     : tangy
--%>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Item - XXX Website</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link href="styles.css" rel="stylesheet">
</head>
<body>
    <div class="header">
        <span>xxx website</span>
        <div>
            <a href="retailer" class="text-white">Back</a>
        </div>
    </div>
    <div class="main">
        <div class="container">
            <h2 class="text-center">Add Item</h2>
            <form action="retailer" method="post">
                <input type="hidden" name="action" value="add">
                <div class="form-group">
                    <label for="itemName">Item Name</label>
                    <input type="text" class="form-control" id="itemName" name="itemName" placeholder="Enter item name">
                </div>
                <div class="form-group">
                    <label for="quantity">Quantity</label>
                    <input type="number" class="form-control" id="quantity" name="quantity" placeholder="Enter quantity">
                </div>
                <div class="form-group">
                    <label for="expirationDate">Expiration Date</label>
                    <input type="date" class="form-control" id="expirationDate" name="expirationDate">
                </div>
                <div class="form-group">
                    <label for="priceType">Price Type</label>
                    <select class="form-control" id="priceType" name="priceTypeID">
                        <option value="">Select</option>
                        <!-- Populate price types dynamically if needed -->
                    </select>
                </div>
                <div class="form-group">
                    <label for="price">Price</label>
                    <input type="text" class="form-control" id="price" name="price" placeholder="Enter price">
                </div>
                <div class="text-center mt-3">
                    <button type="submit" class="btn btn-custom btn-block">Save</button>
                </div>
            </form>
        </div>
    </div>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>


