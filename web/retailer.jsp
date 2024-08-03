<%@page import="entity.FoodItem, entity.Retailer"%>
<%@page import="java.util.List"%>
<%@page import="service.PriceTypeService, service.PriceTypeServiceImpl"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Retailer Items - Food Waste Reduction Platform</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .header {
            background-color: #28a745;
            color: white;
            padding: 10px;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .header a {
            color: white;
            text-decoration: none;
            font-weight: bold;
        }

        .header .navbar-brand {
            font-size: 24px;
        }

        .container {
            margin-top: 30px;
        }
        
        .btn-primary {
            background-color: #007bff;
            border-color: #007bff;
        }

        .btn-warning {
            background-color: #ffc107;
            border-color: #ffc107;
        }

        .btn-danger {
            background-color: #dc3545;
            border-color: #dc3545;
        }

        .text-center {
            margin-bottom: 20px;
        }
    </style>
</head>
<body>
    <div class="header">
        <a class="navbar-brand" href="<%= request.getContextPath() %>/index.jsp">Food Waste Reduction Platform</a>
        <div>
            <a href="<%= request.getContextPath() %>/LogoutController" class="btn btn-outline-light">Logout</a>
        </div>
    </div>

    <div class="container">
        <h2 class="text-center">Welcome back, <%= ((Retailer) session.getAttribute("retailer")).getUsername() %></h2>

        <div class="text-right mb-3">
            <a href="<%= request.getContextPath() %>/showAddRetailerItem.jsp" class="btn btn-primary">Add New Item</a>
        </div>

        <table class="table table-hover table-bordered">
            <thead class="thead-dark">
            <tr>
                <th scope="col">Item ID</th>
                <th scope="col">Item Name</th>
                <th scope="col">Quantity</th>
                <th scope="col">Expiration Date</th>
                <th scope="col">Price Type</th>
                <th scope="col">Price</th>
                <th scope="col">Is Surplus</th>
                <th scope="col">Options</th>
            </tr>
            </thead>
            <tbody>
            <%
                List<FoodItem> foodItems = (List<FoodItem>) request.getAttribute("foodItems");
                PriceTypeService priceTypeService = new PriceTypeServiceImpl();

                if (foodItems != null && !foodItems.isEmpty()) {
                    for (FoodItem foodItem : foodItems) {
            %>
            <tr>
                <td><%= foodItem.getItemID() %></td>
                <td><%= foodItem.getItemName() %></td>
                <td><%= foodItem.getQuantity() %></td>
                <td><%= foodItem.getExpirationDate() %></td>
                <td><%= priceTypeService.showPriceType(foodItem.getPriceTypeID()) %></td>
                <td><%= foodItem.getPrice() %></td>
                <td><%= foodItem.getIsPlus() == 1 ? "Yes" : "No" %></td>
                <td>
                    <a href="<%= request.getContextPath() %>/retailer/safe/editRetailerItem.jsp?editItemID=<%= foodItem.getItemID() %>" class="btn btn-warning btn-sm">Update</a>
                    <% if (foodItem.getIsPlus() == 1) { %>
                        <a href="<%= request.getContextPath() %>/retailer/safe/surplusItem.jsp?surplusItemID=<%= foodItem.getItemID() %>" class="btn btn-danger btn-sm">Surplus</a>
                    <% } %>
                </td>
            </tr>
            <%
                    }
                } else {
            %>
            <tr>
                <td colspan="8" class="text-center">No items available</td>
            </tr>
            <%
                }
            %>
            </tbody>
        </table>
    </div>

    <%@include file="Footer.jsp"%>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
